package uz.bank.kapital.appkapitalbank.entity;

import lombok.*;
import uz.bank.kapital.appkapitalbank.payload.OrderWithoutDetails;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedNativeQuery(name = "Order.ordersWithoutDetails",
        query = "select sys_order.id as id ,sys_order.customer_id as customerId,sys_order.date as date from sys_order join detail " +
                " on not sys_order.id=detail.order_id  where sys_order.date<'2016-09-06'",
        resultSetMapping = "Mapping.OrdersWithoutDetails")

@SqlResultSetMapping(name = "Mapping.OrdersWithoutDetails",
        classes = @ConstructorResult(targetClass = OrderWithoutDetails.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "customerId"),
                        @ColumnResult(name = "date")


                }))

@Entity(name = "sys_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "order", cascade = CascadeType.PERSIST)
    private Invoice invoice;

    public void setInvoice(Invoice invoice) {
        invoice.setOrder(this);
        this.invoice = invoice;
    }
}
