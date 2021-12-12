package uz.bank.kapital.appkapitalbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String name;

    @ManyToOne
    private Category category;

    @Column(length = 20)
    private String description;

    @Column(columnDefinition = "numeric(6,2)")
    private Double price;

    @OneToOne
    private Attachment attachment;

    public Product(String name, Category category, String description, Double price, Attachment attachment) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.attachment = attachment;
    }
}
