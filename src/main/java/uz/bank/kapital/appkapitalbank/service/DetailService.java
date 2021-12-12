package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.DetailDto;

import java.util.Set;

public interface DetailService {

    ApiResponse add(Set<DetailDto> detailDto);

    ApiResponse getProductDetailsByProductId(Integer productId);
}
