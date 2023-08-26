package com.couponapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Coupon {
	private int id;
	private String couponCode;
	private int discountPercentage;
	private Date expiredOn;
}
