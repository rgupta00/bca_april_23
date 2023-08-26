package com.orderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
	private String id;
	private double totalPrice;
	private Date orderDate;
	private Customer customer;
	private Product product;

}