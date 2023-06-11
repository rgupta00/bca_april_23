package com.productapp;

import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

//IF U WANT TO CONFIGURE UR OWN DATASOURCE ==> THIS U NEED TO DO
@SpringBootApplication
public class Productapp01Application {


	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}


	@Bean
	public CommandLineRunner runner(){


		return (arg)->{
			productService.addProduct(new Product("dell laptop", new BigDecimal(120000),"EL"));
			productService.addProduct(new Product("laptop stand", new BigDecimal(1600),"EL"));
			productService.addProduct(new Product("laptop Mouse", new BigDecimal(1800),"EL"));
			productService.addProduct(new Product("rich dad poor dad", new BigDecimal(1800),"BOOK"));
		};

	}

}















