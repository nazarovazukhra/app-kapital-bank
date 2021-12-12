package uz.bank.kapital.appkapitalbank.payload;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class OrderDto {

    private Integer customerId;
    private Date due;
//    private List<DetailDto> detailDto;
}
