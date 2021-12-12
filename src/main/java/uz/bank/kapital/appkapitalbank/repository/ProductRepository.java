package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bank.kapital.appkapitalbank.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {


}
