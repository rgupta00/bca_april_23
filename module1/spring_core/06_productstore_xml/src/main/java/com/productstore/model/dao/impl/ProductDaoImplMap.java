package com.productstore.model.dao.impl;

import com.productstore.model.dao.ProductDao;
import com.productstore.model.dto.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;
@Repository
//Primary
public class ProductDaoImplMap implements ProductDao {
    private HashMap<Integer, Product> productsMap;
    private int counter=0;
    public ProductDaoImplMap() {
        productsMap=new HashMap<Integer, Product>();
        productsMap.put(1, new Product(1, "desktop", new BigDecimal(55000)));
        productsMap.put(2, new Product(2, "Mouse pad", new BigDecimal(550)));
        productsMap.put(3, new Product(3, "Torch", new BigDecimal(520)));
        counter=3;


    }
    @Override
    public List<Product> getAll() {
        System.out.println("getAll using hashmap");
        return new ArrayList<Product>(productsMap.values());
    }

    @Override
    public Product getById(Integer id) {
        return productsMap.get(id);
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Integer id) {
        return null;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        return null;
    }
}
