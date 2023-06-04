package com.productapp.util;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;

public class ConversionUtil {
    //Product -> ProductDto

    public static ProductDto convertToProductDto(Product product){
        ProductDto productDto = ProductDto.builder()
        		.id(product.getId())
        		.name(product.getName())
        		.price(product.getPrice())
        		.build();
        return productDto;
    }

    public static Product convertToProduct(ProductDto productDto){
        Product product = Product.builder()
        		.id(productDto.getId())
        		.name(productDto.getName())
        		.price(productDto.getPrice())
        		.build();
        return product;
    }

    //ProductDto-> product
}
