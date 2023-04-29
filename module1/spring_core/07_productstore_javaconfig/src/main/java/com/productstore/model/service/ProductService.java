package com.productstore.model.service;

import com.productstore.model.dto.Product;

import java.util.List;
//SL=BL+CCC(AOP)
public interface ProductService {
    public List<Product> getAll();
    public Product getById(Integer id );
    public Product addProduct(Product product);
    public Product deleteProduct(Integer id );
    public Product updateProduct(Integer id, Product product );
}
