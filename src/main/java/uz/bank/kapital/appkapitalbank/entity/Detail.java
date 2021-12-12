package uz.bank.kapital.appkapitalbank.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "order_id", "product_id" }) })
public class Detail   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Column(columnDefinition = "smallint")
    private Short quantity;


    public Detail(Order order, Product product, Short quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}
