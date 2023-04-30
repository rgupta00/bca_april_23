package com.productstore.web.controller;

import com.productstore.model.dto.Product;
import com.productstore.model.service.ProductService;
import com.productstore.model.service.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
        ProductService productService=ctx.getBean("productService", ProductService.class);

//        List<Product> products=productService.getAll();
//        products.forEach(p-> System.out.println(p));

        Product product=new Product("rich dad poor dad",new BigDecimal(400));
        Product p=productService.addProduct(product);

        System.out.println(p);

//        Product product1=productService.getById(1);
//        System.out.println(product1);
//        product1.setPrice(product1.getPrice().add(new BigDecimal(2000)));
//        products=productService.getAll();
//        products.forEach(p-> System.out.println(p));

       // productService.updateProduct(1, product1);

    }
}