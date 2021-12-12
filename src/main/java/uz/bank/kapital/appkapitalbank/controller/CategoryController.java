package uz.bank.kapital.appkapitalbank.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.CategoryDto;
import uz.bank.kapital.appkapitalbank.service.CategoryImplService;
import uz.bank.kapital.appkapitalbank.service.ProductImplService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    final CategoryImplService categoryImplService;
    final ProductImplService productImplService;


    public CategoryController(CategoryImplService categoryImplService, ProductImplService productImplService) {
        this.categoryImplService = categoryImplService;
        this.productImplService = productImplService;
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody CategoryDto categoryDto) {
        ApiResponse apiResponse = categoryImplService.add(categoryDto);
        return ResponseEntity.status(apiResponse.getSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/list")
    public HttpEntity<?> getCategoryList() {
        ApiResponse apiResponse = categoryImplService.getCategoryList();
        return ResponseEntity.status(apiResponse.getSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(apiResponse);
    }

    @GetMapping("/{productId}")
    public HttpEntity<?> getProductCategoryByProductId(@PathVariable Integer productId){

        ApiResponse apiResponse=productImplService.getProductCategoryByProductId(productId);
        return ResponseEntity.status(apiResponse.getSuccess()?200:409).body(apiResponse);

    }

}
