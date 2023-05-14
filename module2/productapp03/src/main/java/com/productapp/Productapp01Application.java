package com.productapp;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.Arrays;
//IF U WANT TO CONFIGURE UR OWN DATASOURCE ==> THIS U NEED TO DO
@SpringBootApplication
public class Productapp01Application {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}


	//@Bean
	public CommandLineRunner runner(){
		return (arg)->{
			productService.addProduct(new Product("dell laptop", new BigDecimal(120000)));
			productService.addProduct(new Product("laptop stand", new BigDecimal(1600)));
			productService.addProduct(new Product("laptop Mouse", new BigDecimal(1800)));
			System.out.printf("----------------------");
		};

	}

}















