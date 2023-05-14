package com.productapp.dao.impl;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
@Primary
public class ProductDaoJpaImpl implements ProductDao {

    private EntityManager em;

    @Autowired
    public ProductDaoJpaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Product> getAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public Product addProduct(Product product) {
        em.persist(product);
        return product;
    }
}
