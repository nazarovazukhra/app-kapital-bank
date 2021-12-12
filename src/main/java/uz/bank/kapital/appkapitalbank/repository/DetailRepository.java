package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.bank.kapital.appkapitalbank.entity.Detail;
import uz.bank.kapital.appkapitalbank.payload.BulkProducts;
import uz.bank.kapital.appkapitalbank.payload.HighDemandProducts;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Integer> {

    List<Detail> findAllByProductId(Integer productId);


    @Query(value = "select p.id as id,p.name as name ,sum(detail.quantity) as totalProductQuantity,count(detail.order_id) as totalOrderQuantity  from  detail join product p on p.id = detail.product_id " +
            "join sys_order so on so.id = detail.order_id " +
            "where  (select count(detail.order_id) from detail join sys_order so on so.id = detail.order_id) >10 " +
            "group by p.id,p.name", nativeQuery = true)
    List<HighDemandProducts> highDemandProducts();

    @Query(value = " select p.id as id ,p.name as name ,p.price as price,sum(detail.quantity) as totalQuantity from detail join sys_order so on so.id = detail.order_id " +
            " join product p on p.id = detail.product_id " +
            " where detail.quantity >= 8 " +
            " group by p.id, p.name, p.price", nativeQuery = true)
    List<BulkProducts> bulkProducts();

}
