package com.productapp.service;

import com.productapp.dto.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public Product addProduct(Product product);
}
