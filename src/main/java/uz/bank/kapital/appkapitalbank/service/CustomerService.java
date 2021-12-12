package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.entity.Customer;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;

public interface CustomerService {
    ApiResponse add(Customer customer);
}
