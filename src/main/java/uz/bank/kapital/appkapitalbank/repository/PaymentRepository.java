package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.bank.kapital.appkapitalbank.entity.Order;
import uz.bank.kapital.appkapitalbank.entity.Payment;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.OverpaidInvoiceDAO;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
//
//    @Query(value = "select new uz.bank.kapital.apkapitalbank.payload.OverpaidInvoiceDAO" +
//            " (sum(p.amount),sum( distinct i.amount )  " +
//            "  (sum(p.amount) -sum( distinct i.amount )) )" +
//            "from payment p join invoice i on i.id = p.invoice_id" +
//            "group by p.invoice_id",nativeQuery = true)
//    List<OverpaidInvoiceDAO> overpaidInvoice();

    @Query(value = "select  sum(p.amount) as payedAmount ,sum( distinct i.amount ) as totalAmount, " +
            "       (sum(p.amount) -sum( distinct i.amount )) as diffAmount,c.id as customerId, " +
            "       c.name as name,c.surname as surname " +
            "from payment p join invoice i on i.id = p.invoice_id " +
            "join invoice i2 on i2.id = p.invoice_id " +
            "join sys_order so on so.id = i.order_id " +
            "join customer c on c.id = so.customer_id " +
            "group by p.invoice_id, c.id", nativeQuery = true)
    List<OverpaidInvoiceDAO> overpaidInvoice();


}
