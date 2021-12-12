package uz.bank.kapital.appkapitalbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bank.kapital.appkapitalbank.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
