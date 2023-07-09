package com.productapp.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

//OOPs: SRP
//Product : Entity and it working as DTO and validation
//2 sepate classes Product in entity package and one in dto
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @NotEmpty(message = "name should be left black")
    private String name;

   // @NotNull(message = "product.price.absent")
  //  @Range(min = 100, max = 200000, message = "product.price.invalid")
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}










