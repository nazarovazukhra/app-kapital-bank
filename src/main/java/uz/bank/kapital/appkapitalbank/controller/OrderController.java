package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.OrderDto;
import uz.bank.kapital.appkapitalbank.service.OrderImplService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    final OrderImplService orderImplService;

    public OrderController(OrderImplService orderImplService) {
        this.orderImplService = orderImplService;
    }


    @PostMapping
    public HttpEntity<?> add(@RequestBody OrderDto orderDto) {
        ApiResponse apiResponse = orderImplService.add(orderDto);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }
}
