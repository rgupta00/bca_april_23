package com.productapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ProductDto {
    private int id;

    @NotEmpty(message = "name should be left black")
    private String name;

    @NotNull(message = "product.price.absent")
    @Range(min = 100, max = 100000, message = "product.price.invalid")
    private BigDecimal price;

    public ProductDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}










