package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

}
