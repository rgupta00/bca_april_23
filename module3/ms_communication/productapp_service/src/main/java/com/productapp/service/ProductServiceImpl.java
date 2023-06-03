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

    @CacheEvict(value = "products", allEntries = true)
    @Override
    public void removeCache() {
        System.out.println("------------cache is clean...");
    }

    @Override
    public List<Product> getAllSortedAsPerField(String fieldName) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, fieldName));
    }

    @Override
    public Page<Product> getAllSortedPagination(int offset, int pageNo) {
        Page<Product> productPages= productRepo.findAll(PageRequest.of(offset, pageNo));
       // productPages.ge
        return productPages;
    }

    @Override
    public Page<Product> getAllSortedPaginationAndPerField(int offset, int pageNo, String fieldName) {
        return productRepo.findAll(PageRequest.of(offset, pageNo).withSort(Sort.by(fieldName)));
    }

    @Cacheable(value = "products")
    @Override
    public List<Product> getAll() {
        System.out.println("--------------------------------------------------");
//        if(1==1)
//            throw new NullPointerException("some db problem");
        long start=System.currentTimeMillis();
        List<Product> getAll= productRepo.findAll();
        long end=System.currentTimeMillis();

        logger.info("******************time taken to execute method is ,{}", (end-start)+" ms ");

        return getAll;
    }

    @Override
    public Product addProduct(Product product) {
         productRepo.save(product);
         return product;
    }

    @Override
    @CachePut(value = "products", key = "#result.id")
    public Product updateProduct(int productId, Product product) {
        Product productToUpdate= getProductById(productId);
        productToUpdate.setPrice(product.getPrice());

        productRepo.save(productToUpdate);

        return productToUpdate;
    }

    @CacheEvict(value = "products", key = "#productId")
    @Override
    public Product deleteProduct(int productId) {
        Product productToDelete= getProductById(productId);
        productRepo.delete(productToDelete);
        return productToDelete;
    }

    //Java 8 topic
    @Cacheable(value = "products", key = "#productId")
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
