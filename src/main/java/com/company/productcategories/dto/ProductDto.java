package com.company.productcategories.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private  String productName;
    private  Integer count;
    private String origin;
    private Integer manufacturingDate;
    private Double price;
}
