package com.productapp;

import com.productapp.dto.ProductDto;
import com.productapp.entities.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

//IF U WANT TO CONFIGURE UR OWN DATASOURCE ==> THIS U NEED TO DO
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Productstore API", version = "2.0" , description = "BusyCoder API"))
//@EnableCaching
//@EnableScheduling
public class Productapp01Application {

	@Bean
	public CacheManager cacheManager() {
		ConcurrentMapCacheManager cacheManager=
				new ConcurrentMapCacheManager("products");

		return cacheManager;
	}


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

//			List<Product> products=IntStream.rangeClosed(1,10_00)
//					.mapToObj(i-> new Product("product "+ i, new BigDecimal(new Random().nextInt(1000)))).toList();
//
//			productRepo.saveAll(products);
//			System.out.println("----------------------");


			productService.addProduct(new Product("dell laptop", new BigDecimal(120000),"EL"));
			productService.addProduct(new Product("laptop stand", new BigDecimal(1600),"EL"));
			productService.addProduct(new Product("laptop Mouse", new BigDecimal(1800),"EL"));
			productService.addProduct(new Product("rich dad poor dad", new BigDecimal(1800),"BOOK"));

//			System.out.printf("----------------------");
		};

	}

}















