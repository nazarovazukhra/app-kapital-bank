package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bank.kapital.appkapitalbank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByNameAndSurnameAndPhone(String name, String surname, String phone);
}
