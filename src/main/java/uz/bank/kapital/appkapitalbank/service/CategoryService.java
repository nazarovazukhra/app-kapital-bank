package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.CategoryDto;

public interface CategoryService {


    ApiResponse add(CategoryDto categoryDto);

    ApiResponse getCategoryList();

}
