package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.ProductRepo;
import com.productapp.entities.Product;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	
	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepo.findById(id).orElseThrow(ProductNotFoundException:: new);
	}

	@Override
	public Product save(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public Product delete(int id) {
		Product productToDelete=getProductById(id);
		productRepo.delete(productToDelete);
		return productToDelete;
	}

	@Override
	public Product update(int id, Product product) {
		Product productToUpdate=getProductById(id);
		productToUpdate.setPrice(product.getPrice());
		productRepo.save(productToUpdate);
		
		return productToUpdate;
	}
	
}
