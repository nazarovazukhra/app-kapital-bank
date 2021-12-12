package uz.bank.kapital.appkapitalbank.service;

import org.springframework.stereotype.Service;
import uz.bank.kapital.appkapitalbank.entity.Category;
import uz.bank.kapital.appkapitalbank.payload.ApiResponse;
import uz.bank.kapital.appkapitalbank.payload.CategoryDto;
import uz.bank.kapital.appkapitalbank.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryImplService implements CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryImplService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ApiResponse add(CategoryDto categoryDto) {

        Category category = new Category();
        category.setName(categoryDto.getName());

        if(categoryDto.getParentCategoryId()!=null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalCategory.isPresent())
                return new ApiResponse("Such category not found", false);

            category.setParentCategory(optionalCategory.get());
        }
        categoryRepository.save(category);
        return new ApiResponse("Category added", true);


    }

    @Override
    public ApiResponse getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty())
            return new ApiResponse("Any category not found", false);
        return new ApiResponse(true, categoryList);
    }
}
