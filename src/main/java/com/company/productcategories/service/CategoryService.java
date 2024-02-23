package com.company.productcategories.service;

import com.company.productcategories.entity.CategoryEntity;
import com.company.productcategories.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CategoryService {

    private  final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;


    public List<CategoryEntity> findAllCategories () {
        List<CategoryEntity> all = categoryRepo.findAll();
        return all.stream()
                .map(categoryEntity -> modelMapper.map(categoryEntity, CategoryEntity.class))
                .collect(Collectors.toList());
    }

    public void createCategory (CategoryEntity categoryEntity) {
        CategoryEntity map = modelMapper.map(categoryEntity, CategoryEntity.class);
        categoryRepo.save(map);

    }

    public ResponseEntity<String> deleteCategoryById (Long id) {
        categoryRepo.deleteById(id);
        return ResponseEntity.ok("Category deleted!");
    }


}
