package uz.bank.kapital.appkapitalbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false,columnDefinition = "numeric(8,2)")
    private Double amount;

    @ManyToOne
    private Invoice invoice;

    public Payment(Timestamp time, Double amount, Invoice invoice) {
        this.time = time;
        this.amount = amount;
        this.invoice = invoice;
    }
}
