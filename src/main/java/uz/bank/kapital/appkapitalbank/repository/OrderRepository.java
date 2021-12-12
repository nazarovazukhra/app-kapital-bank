package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.bank.kapital.appkapitalbank.entity.Order;
import uz.bank.kapital.appkapitalbank.payload.*;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {


    @Query(value = "select sys_order.id as orderId , sys_order.date as orderDate,  sys_order.customer_id as customerId ," +
            " customer.name as name, customer.surname as surname  from sys_order" +
            " join detail on not sys_order.id=detail.order_id " +
            "join customer on customer.id=sys_order.customer_id" +
            " where  sys_order.date<'2016-09-06'", nativeQuery = true)
    List<OrderWithoutDetails> ordersWithoutDetails();

    @Query(value = "select distinct customer.id as id ,customer.name as name,customer.surname as surname from  sys_order so " +
            " join customer on customer.id = so.customer_id where so.date not between '2016-01-01' and '2016-12-31'", nativeQuery = true)
    List<CustomerWithoutOrder> customerWithoutOrder();

    @Query(value = "select c.id as customerId, c.surname as surname,c.name as name ,max(sys_order.date) as lastOrderDate from sys_order " +
            " join customer c on c.id = sys_order.customer_id " +
            " group by c.id, c.surname,c.name ", nativeQuery = true)
    List<CustomerLastOrder> customerLastOrder();

    @Query(value = "select c.country as country ,count(sys_order.id) as totalOrder from sys_order join customer c on c.id = sys_order.customer_id " +
            " where  sys_order.date between '2016-01-01' and '2016-12-31' " +
            " group by c.country", nativeQuery = true)
    List<NumberOfProductsInYear> numberOfProductsInYear();


}
