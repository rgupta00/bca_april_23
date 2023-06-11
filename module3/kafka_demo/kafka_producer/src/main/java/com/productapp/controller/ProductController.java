package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProducerService;

@RestController
public class ProductController {
	
	@Autowired
	private ProducerService producerService;
	
	
	@PostMapping("producer")
	public String sendMessage(@RequestBody  Product product) {
		
		producerService.produce(product);
		
		return "message is send";
		
	}
	
	

}
