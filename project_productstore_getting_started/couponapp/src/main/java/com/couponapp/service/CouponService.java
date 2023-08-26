package com.couponapp.service;

import com.couponapp.dto.Coupon;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CouponService {
    public Coupon getCoupon(String couponCode){
        Coupon coupon=null;
        if(couponCode.equalsIgnoreCase("SUP10"))
            coupon=new Coupon(1,couponCode,10, new Date());
        else if(couponCode.equalsIgnoreCase("SUP15"))
            coupon=new Coupon(1,couponCode,15, new Date());
        else if(couponCode.equalsIgnoreCase("SUP20"))
            coupon=new Coupon(1,couponCode,20, new Date());
        else
            coupon=new Coupon(1,couponCode,5, new Date());
        return coupon;
    }
}
