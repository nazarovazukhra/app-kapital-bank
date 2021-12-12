package uz.bank.kapital.appkapitalbank.payload;

import lombok.Data;

@Data
public class PaymentDto {

    private Double amount;
    private Integer invoiceId;
}
