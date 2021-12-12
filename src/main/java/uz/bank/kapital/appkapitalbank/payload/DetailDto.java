package uz.bank.kapital.appkapitalbank.payload;

import lombok.Data;

@Data
public class DetailDto {

    private Integer productId;
    private Short quantity;
    private Integer orderId;
}
