package com.demo.basics2;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString
@EqualsAndHashCode
public class Customer {

	private Integer id;
	private String name;

	private String address;

	private String mobile;

	public Customer(String name, String address, String mobile) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}
}
