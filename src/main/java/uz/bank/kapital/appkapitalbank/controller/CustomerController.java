package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bank.kapital.appkapitalbank.entity.Customer;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.repository.CustomerRepository;
import uz.bank.kapital.appkapitalbank.service.CustomerImplService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    final CustomerImplService customerImplService;
final CustomerRepository customerRepository;
    public CustomerController(CustomerImplService customerImplService, CustomerRepository customerRepository) {
        this.customerImplService = customerImplService;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody Customer customer){
        ApiResponse apiResponse=customerImplService.add(customer);
        return ResponseEntity.status(apiResponse.getSuccess()?200:409).body(apiResponse);
    }

    @GetMapping
    public List<Customer> all(){
        return customerRepository.findAll();
    }
}
