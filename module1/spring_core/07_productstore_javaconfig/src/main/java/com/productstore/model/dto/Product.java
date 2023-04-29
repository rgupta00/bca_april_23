package com.productstore.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
/*
    POJO vs record(immutable) not supported as @Entity by hib
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private BigDecimal price;

}
