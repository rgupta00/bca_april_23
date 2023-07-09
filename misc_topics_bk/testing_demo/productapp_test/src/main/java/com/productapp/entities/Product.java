package com.productapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="product_table")
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
}
