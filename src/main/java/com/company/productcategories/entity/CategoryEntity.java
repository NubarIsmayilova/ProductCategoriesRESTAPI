package com.company.productcategories.entity;


import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
public class CategoryEntity {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;
    private String description;



    @OneToMany (mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;

}

