package pl.restapi.app.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.restapi.app.demo.model.Category;
import pl.restapi.app.demo.services.CategoryService;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/api/")
public class CategoryController {
    private CategoryService categoryService

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public ResponseEntity<List<Category>> showALLCategories(){
        return ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }
}
