package com.productstore.model.service;

import com.productstore.model.dao.ProductDao;
import com.productstore.model.dao.impl.ProductDaoImplMap;
import com.productstore.model.dto.Product;
import com.productstore.model.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "productService")
public class ProductServiceImpl implements ProductService{

    private ProductDao productDao;

    //Ctr vs Setter
    //Mandatroy vs optional
    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Product getById(Integer id) {
        Product product= productDao.getById(id);
        if(product==null)
            throw  new ResourceNotFoundException("product with id  "+ id+" is not found");
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public Product deleteProduct(Integer id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        return productDao.updateProduct(id, product);
    }
}
