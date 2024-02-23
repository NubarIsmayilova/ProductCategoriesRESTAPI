package com.company.productcategories.service;

import com.company.productcategories.entity.CategoryEntity;
import com.company.productcategories.entity.ProductEntity;
import com.company.productcategories.repository.CategoryRepo;
import com.company.productcategories.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepo productRepo;
    private final ModelMapper modelMapper;


    public void createProduct (ProductEntity productEntity) {
        ProductEntity map = modelMapper.map(productEntity, ProductEntity.class);
        productRepo.save(map);

    }

    public ResponseEntity<String> deleteProductById (Long id) {
        productRepo.deleteById(id);
        return ResponseEntity.ok("Product deleted!");
    }

    public List<ProductEntity> findAllProducts () {
        List<ProductEntity> productRepoAll = productRepo.findAll();
        return productRepoAll.stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductEntity.class))
                .collect(Collectors.toList());
    }


    public List<ProductEntity> findProductByCategoryName (String givenCategoryName) {
        return productRepo.findAllProductsByProductName(givenCategoryName);
    }

    public List<ProductEntity> findTotalPriceByCategoryName (String priceByCategoryName) {
        return productRepo.findAllProductsByProductName(priceByCategoryName);
    }


    public ProductEntity findExpensive (Double expensiveProduct) {
        return productRepo.findAllByPrice (expensiveProduct) ;
    }


}
