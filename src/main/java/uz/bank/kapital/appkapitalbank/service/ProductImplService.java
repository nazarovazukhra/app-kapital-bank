package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.Category;
import uz.bank.kapital.appkapitalbank.entity.Product;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.ProductDto;
import uz.bank.kapital.appkapitalbank.repository.CategoryRepository;
import uz.bank.kapital.appkapitalbank.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplService implements ProductService {

    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;

    public ProductImplService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ApiResponse add(ProductDto productDto) {

        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent())
            return new ApiResponse("Such category not found", false);

        Product product = new Product(
                productDto.getName(), optionalCategory.get(), productDto.getDescription(),
                productDto.getPrice(), null
        );
        productRepository.save(product);
        return new ApiResponse("Product added", true);


    }


    @Override
    public ApiResponse getProductCategoryByProductId(Integer productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            return new ApiResponse("Such product with this id not found", false);
        }
        return new ApiResponse(true, optionalProduct.get().getCategory());

        //        return optionalProduct.map(product -> new ApiResponse(true, product.getCategory())).orElseGet(()
//                -> new ApiResponse("Such product with this id not found", false));

    }

    @Override
    public ApiResponse getProductList() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty())
            return new ApiResponse("Any product not found", false);
        return new ApiResponse(true, productList);

    }

    @Override
    public ApiResponse getProductById(Integer id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent())
            return new ApiResponse("Such product not with this id found", false);
        return new ApiResponse(true, optionalProduct.get());
    }
}
