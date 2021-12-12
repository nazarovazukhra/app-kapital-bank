package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.OrderDto;

public interface OrderService {
    ApiResponse add(OrderDto orderDto);
}
