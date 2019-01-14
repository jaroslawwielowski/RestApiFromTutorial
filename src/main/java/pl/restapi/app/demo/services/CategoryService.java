package pl.restapi.app.demo.services;

import org.springframework.stereotype.Service;
import pl.restapi.app.demo.model.Category;
import pl.restapi.app.demo.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
