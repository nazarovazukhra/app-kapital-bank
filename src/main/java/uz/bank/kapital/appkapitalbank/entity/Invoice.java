package uz.bank.kapital.appkapitalbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Order order;

    @Column(nullable = false, columnDefinition = "numeric(8,2)")
    private Double amount;

    @Column(nullable = false)
    private Date issued;      // issued --> createdDate

    @Column(nullable = false)
    private Date due;         // due --> dueDate

    public Invoice(Order order, Double amount, Date issued, Date due) {
        this.order = order;
        this.amount = amount;
        this.issued = issued;
        this.due = due;
    }
}
