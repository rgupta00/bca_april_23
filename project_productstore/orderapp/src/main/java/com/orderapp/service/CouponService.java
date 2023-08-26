package com.orderapp.service;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class CouponService {

    private RestTemplate restTemplate;

    @Autowired
    public CouponService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @CircuitBreaker(fallbackMethod = "getCouponFallback", name = "couponservice")
    public Coupon getCoupon(OrderRequest orderRequest) {
        System.out.println("-***************************");
        System.out.println("getcoupon is called");
        System.out.println("-***************************");
        Coupon coupon=restTemplate.
                getForObject("http://COUPON-SERVICE/couponapp/coupons/"+
                orderRequest.getCouponCode(), Coupon.class);
        return coupon;
    }
    public Coupon getCouponFallback(OrderRequest orderRequest, Exception ex) {
        System.out.println("-----------------------------");
        System.out.println(ex.getMessage());
        System.out.println("-----------------------------");
        return new Coupon(1,"SUP10", 10, new Date());
    }
}
