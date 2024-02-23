package com.company.productcategories.controller;
import com.company.productcategories.entity.CategoryEntity;
import com.company.productcategories.entity.ProductEntity;
import com.company.productcategories.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/products")
    public List<ProductEntity> getAllProducts () {
       return productService.findAllProducts();
    }

    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct (@RequestBody ProductEntity productEntity) {
        productService.createProduct(productEntity);
        return ResponseEntity.ok("Product created!");
    }

    @DeleteMapping("/deleteProduct{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product deleted!");
    }

    @GetMapping("/products-category{categoryName}")
    public List<ProductEntity> getProductByCategoryName (@PathVariable String categoryName) {
        return productService.findProductByCategoryName(categoryName);
    }


    @GetMapping("/get-by-total-price")
    public  List<ProductEntity> findTotalPriceByName (String totalPriceByName) {
        return productService.findTotalPriceByCategoryName(totalPriceByName);
    }

    @GetMapping("/get-expensive")
    public ProductEntity findExpensiveByName (Double productName) {
        return productService.findExpensive(productName);
    }


}
