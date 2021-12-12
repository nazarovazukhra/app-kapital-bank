package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.PaymentDto;
import uz.bank.kapital.appkapitalbank.service.PaymentImplService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    final PaymentImplService paymentImplService;

    public PaymentController(PaymentImplService paymentImplService) {
        this.paymentImplService = paymentImplService;
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody PaymentDto paymentDto){

        ApiResponse apiResponse=paymentImplService.add(paymentDto);
        return ResponseEntity.status(apiResponse.getSuccess()?200:409).body(apiResponse);
    }

}
