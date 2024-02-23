package com.company.productcategories.repository;

import com.company.productcategories.entity.CategoryEntity;
import com.company.productcategories.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepo  extends JpaRepository<ProductEntity, Long> {


    List<ProductEntity> findAllProductsByProductName (String givenName);

//    @Query (value="SELECT SUM(p.price) FROM ProductEntity p WHERE p.category.name = :givenName", nativeQuery = true)
//    Double findTotalPriceByGivenName (@Param("givenName") String givenName);



//    @Query (value="SELECT c.id, c.name, MAX(p.price) FROM CategoryEntity c JOIN c.products p GROUP BY c.id ORDER BY MAX(p.price) DESC")

    ProductEntity findAllByPrice (Double expensiveProduct);


}
