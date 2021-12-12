package uz.bank.kapital.appkapitalbank.service;

import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.PaymentDto;

public interface PaymentService {
    ApiResponse add(PaymentDto paymentDto);
}
