package com.couponapp.controller;

import com.couponapp.dto.Coupon;
import com.couponapp.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }
    @GetMapping(path = "coupons/{couponCode}")
    public Coupon getCoupon(@PathVariable String couponCode){
        return couponService.getCoupon(couponCode);
    }
}
