package com.productapp.controller;

import com.productapp.config.AppConfig;
import com.productapp.model.entities.Product;
import com.productapp.model.service.ProductService;
import com.productapp.model.service.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        //Write the code to test it
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService=context.getBean("ps",ProductService.class);

        Product product=Product.builder()
                .name("lapto cool pad")
                .price(new BigDecimal(1780))
                .build();
        productService.addProduct(product);


    }
}
