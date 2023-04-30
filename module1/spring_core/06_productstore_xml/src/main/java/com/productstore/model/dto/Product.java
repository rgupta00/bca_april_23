package com.productstore.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
/*
    POJO vs record(immutable) not supported as @Entity by hib
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
