package com.productapp.service;

import com.productapp.entities.Product;
import com.productapp.exceptions.ResourceNotFoundException;
import com.productapp.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private  ProductRepo productRepo;

    private Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> getAll() {
        List<Product> getAll= productRepo.findAll();
        return getAll;
    }

    @Override
    public Product addProduct(Product product) {
         productRepo.save(product);
         return product;
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product productToUpdate= getProductById(productId);
        productToUpdate.setPrice(product.getPrice());

        productRepo.save(productToUpdate);

        return productToUpdate;
    }

    @Override
    public Product deleteProduct(int productId) {
        Product productToDelete= getProductById(productId);
        productRepo.delete(productToDelete);
        return productToDelete;
    }

    @Override
    public Product getProductById(int productId) {
        return productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product with id "+ productId+" is not found"));
    }

    @Override
    public List<Product> getAllByName(String productName) {
        return productRepo.findByName(productName);
    }
}
