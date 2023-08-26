package com.orderapp.service;

import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private RestTemplate restTemplate;

    @Autowired
    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Customer getCustomer(OrderRequest orderRequest) {
        Customer customer=restTemplate
                .getForObject("http://CUSTOMER-SERVICE/customerapp/customers/"+
                orderRequest.getCustomerId(), Customer.class);
        return customer;
    }
}
