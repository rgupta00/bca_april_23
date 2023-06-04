package com.productapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

//OOPs: SRP
//Product : Entity and it working as DTO and validation
//2 sepate classes Product in entity package and one in dto
@Entity
@Table(name="product_table")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name should be left black")
    private String name;

    @NotNull(message = "product.price.absent")
    @Range(min = 100, max = 200000, message = "product.price.invalid")
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}










