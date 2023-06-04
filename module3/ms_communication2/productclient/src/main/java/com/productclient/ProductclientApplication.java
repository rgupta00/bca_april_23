package com.productclient;

import com.productclient.services.ProductClientServiceHttpExProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
//1. jar file pom done
//2.
@EnableFeignClients("com.productclient.services")
public class ProductclientApplication {
	//WebClient 		vs 		(RestTemplate)  (Reactive*)


	//Define a bean so that spring know that it need to provide a impleme...ProductClientServiceHttpExProxy

	@Bean
	ProductClientServiceHttpExProxy postClient(WebClient webClient) {
		HttpServiceProxyFactory httpServiceProxyFactory =
				HttpServiceProxyFactory.builder(WebClientAdapter.forClient(getClient()))
						.build();
		return httpServiceProxyFactory.createClient(ProductClientServiceHttpExProxy.class);
	}

	@Bean
	public WebClient getClient(){
		return WebClient.builder().
				baseUrl("http://localhost:8080").build();
	}

	//1. define RestTemplate
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {

		SpringApplication.run(ProductclientApplication.class, args);
	}

}
