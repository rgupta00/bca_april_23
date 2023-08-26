package com.orderapp.controller;

import com.orderapp.dto.*;
import com.orderapp.service.CouponService;
import com.orderapp.service.CustomerService;
import com.orderapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@RestController
public class OrderController {
    @Autowired
    private CouponService couponService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;


    @PostMapping(path = "orders")
    public ResponseEntity<OrderResponse> bookOrder(@RequestBody OrderRequest orderRequest){

        //talk to other ms
        Coupon coupon=couponService.getCoupon(orderRequest);

        Product product=productService.getProduct(orderRequest);


        Customer customer=customerService.getCustomer(orderRequest);


        double netPrice=product.getPrice()-product.getPrice()* coupon.getDiscountPercentage()/100;

        OrderResponse orderResponse=new OrderResponse();

        orderResponse.setId(UUID.randomUUID().toString());
        orderResponse.setProduct(product);

        orderResponse.setCustomer(customer);


        orderResponse.setTotalPrice(netPrice*orderRequest.getQty());

        orderResponse.setOrderDate(new Date());

        return  ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }
}
