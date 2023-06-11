package com.productapp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.productapp.dto.Product;

@Service
public class ProducerService {
	
	
	private static final String PRODUCTAPPTOPIC = "productapptopic";
	
	@KafkaListener(topics =PRODUCTAPPTOPIC, groupId = "my_group_id" )
	public void produce(Product product) {
		System.out.println("message is recived :"+ product);
	}
	

}
