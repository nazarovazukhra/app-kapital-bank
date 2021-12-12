package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.bank.kapital.appkapitalbank.entity.Invoice;
import uz.bank.kapital.appkapitalbank.payload.OrdersWithoutInvoices;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query(value = "select * from invoice where due < issued  and amount > 0.0", nativeQuery = true)
    List<Invoice> expiredInvoices();

    @Query(value = "select * from invoice " +
            "where due > issued and amount > 0.0", nativeQuery = true)
    List<Invoice> wrongDateInvoices();


    Optional<Invoice> findByOrderId(Integer orderId);


    @Query(value = "select distinct so.id as orderId,so.date as date ,p.name as name ,d.quantity as quantity,p.price as price, (d.quantity* p.price) as eachProductTotalPrice from invoice join sys_order so on not so.id = invoice.order_id " +
            " join detail d on so.id = d.order_id " +
            " join product p on p.id = d.product_id ",nativeQuery = true)
    List<OrdersWithoutInvoices> ordersWithoutInvoices();
}
