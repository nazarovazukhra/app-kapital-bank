package uz.bank.kapital.appkapitalbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "surname", "phone"}))
public class Customer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 14)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, columnDefinition = "char(3)")
    private String country;

    @Column(columnDefinition = "text")
    private String address;

    @Column(length = 50)
    private String phone;

    public Customer(String name, String surname, String country, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.address = address;
        this.phone = phone;
    }
}
