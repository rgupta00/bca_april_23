package com.orderapp.service;

import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProduct(OrderRequest orderRequest) {
        Product product=restTemplate.getForObject("http://PRODUCT-SERVICE/productapp/products/"+
                orderRequest.getProductId(), Product.class);
        System.out.println(product);
        return product;
    }
}
