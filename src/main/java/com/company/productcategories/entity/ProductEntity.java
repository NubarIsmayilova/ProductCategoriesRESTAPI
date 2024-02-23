package com.company.productcategories.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "products")
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String productName;
    private  Integer count;
    private String origin;
    private Integer manufacturingDate;
    private Double price;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id")
    private CategoryEntity categoryEntity;
}
