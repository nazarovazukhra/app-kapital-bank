package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.ProductDto;

public interface ProductService {
    ApiResponse add(ProductDto productDto);

    ApiResponse getProductCategoryByProductId(Integer productId);

    ApiResponse getProductList();

    ApiResponse getProductById(Integer id);
}
