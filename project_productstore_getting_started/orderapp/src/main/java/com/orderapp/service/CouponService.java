package com.orderapp.service;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CouponService {

    private RestTemplate restTemplate;

    @Autowired
    public CouponService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Coupon getCoupon(OrderRequest orderRequest) {
        Coupon coupon=restTemplate.getForObject("http://localhost:8085/couponapp/coupons/"+
                orderRequest.getCouponCode(), Coupon.class);

        return coupon;
    }
}
