package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.ProductDto;
import uz.bank.kapital.appkapitalbank.service.DetailImplService;
import uz.bank.kapital.appkapitalbank.service.ProductImplService;

@RestController
@RequestMapping("api/product")
public class ProductController {


    final ProductImplService productImplService;
    final DetailImplService detailImplService;

    public ProductController(ProductImplService productImplService, DetailImplService detailImplService) {
        this.productImplService = productImplService;
        this.detailImplService = detailImplService;
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDto productDto) {
        ApiResponse apiResponse = productImplService.add(productDto);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    @GetMapping("/list")
    public HttpEntity<?> getProductList() {
        ApiResponse apiResponse = productImplService.getProductList();
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }

    @GetMapping("/{id}")
    public HttpEntity<?> getProductById(@PathVariable Integer id) {
        ApiResponse apiResponse = productImplService.getProductById(id);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }
    @GetMapping("/{productId}")
    public HttpEntity<?> getProductDetailsByProductId(@PathVariable Integer productId) {
        ApiResponse apiResponse = detailImplService.getProductDetailsByProductId(productId);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);

    }
}
