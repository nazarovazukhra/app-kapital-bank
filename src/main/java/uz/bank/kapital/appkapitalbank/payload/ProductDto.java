package uz.bank.kapital.appkapitalbank.payload;

import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private Integer categoryId;
    private String description;
    private Double price;
    private Integer attachmentId;
}
