package com.productclient.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.*;

import java.math.BigDecimal;
import lombok.*;

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
    @Range(min = 100, max = 200000, message = "product.price.invalid")
    private BigDecimal price;

    public ProductDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}










