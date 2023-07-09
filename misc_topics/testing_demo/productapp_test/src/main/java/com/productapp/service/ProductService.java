package com.productapp.service;

import java.util.List;

import com.productapp.entities.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getProductById(int id);
	public Product save(Product product);
	public Product delete(int id);
	public Product update(int id, Product product);
}