package com.productapp.dao;

import com.productapp.dto.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public Product addProduct(Product product);
}
