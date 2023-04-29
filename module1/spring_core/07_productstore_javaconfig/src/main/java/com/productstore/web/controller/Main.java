package com.productstore.web.controller;

import com.productstore.config.AppConfig;
import com.productstore.model.dto.Product;
import com.productstore.model.service.ProductService;
import com.productstore.model.service.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService=ctx.getBean("productService", ProductService.class);

        List<Product> products=productService.getAll();
        products.forEach(p-> System.out.println(p));
    }
}