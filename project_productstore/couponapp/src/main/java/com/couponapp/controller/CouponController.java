package com.couponapp.controller;

import com.couponapp.dto.Coupon;
import com.couponapp.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    private CouponService couponService;

    @Value("${my.value: default value}")
    private String myValue;

    private Logger logger = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }
    @GetMapping(path = "coupons/{couponCode}")
    public Coupon getCoupon(@PathVariable String couponCode){
        logger.info("getCoupon method is called...........");
        return couponService.getCoupon(couponCode);
    }
}
