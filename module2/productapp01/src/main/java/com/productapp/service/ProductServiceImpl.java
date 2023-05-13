package com.productapp.service;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }
}
