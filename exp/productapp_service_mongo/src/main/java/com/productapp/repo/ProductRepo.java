package com.productapp.repo;

import com.productapp.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends MongoRepository<Product, Integer> {
    public List<Product> findByName(String name);
}
