package com.company.productcategories.controller;

import com.company.productcategories.entity.CategoryEntity;
import com.company.productcategories.service.CategoryService;
import com.company.productcategories.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/categories")
    public List<CategoryEntity> getAllCategories () {
        return categoryService.findAllCategories();
    }

    @PostMapping("/createCategory")
    public ResponseEntity<String> createCategory (@RequestBody CategoryEntity categoryEntity) {
        categoryService.createCategory(categoryEntity);
        return ResponseEntity.ok("Category created!");
    }

    @DeleteMapping("/deleteCategory{id}")
    public ResponseEntity<String> deleteCategoryById (@PathVariable long id) {
       categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Category deleted!");
    }




}
