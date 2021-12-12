package uz.bank.kapital.appkapitalbank.payload;

import lombok.Data;

@Data
public class CustomerDto {

    private String name;
    private String surname;
    private String address;
    private String phone;
}
