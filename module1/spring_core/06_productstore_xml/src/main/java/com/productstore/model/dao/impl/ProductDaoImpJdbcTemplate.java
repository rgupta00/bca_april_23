package com.productstore.model.dao.impl;

import com.productstore.model.dao.ProductDao;
import com.productstore.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@Repository
@Primary
public class ProductDaoImpJdbcTemplate implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImpJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        //Spring jdbc rs--> java object? RowMapper
        return jdbcTemplate.query("select * from product_table",
                new ProductRowMapper());
    }

    @Override
    public Product getById(Integer id) {
        return jdbcTemplate
                .queryForObject("select * from product_table where id=?",
                        new ProductRowMapper(), id);
    }

    //jdbcTemplate.update
    @Override
    public Product addProduct(Product product) {
        KeyHolder keyHolder=new GeneratedKeyHolder();//holder will keep the auto gen pk

        String sql="insert into product_table(name, price) values (?,?)";
        jdbcTemplate
                .update((con) ->{
                        PreparedStatement pstmt=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        pstmt.setString(1, product.getName());
                        pstmt.setBigDecimal(2, product.getPrice());
                        return pstmt;
                }, keyHolder);

//         jdbcTemplate
//                 .update("insert into product_table(name, price) values (?,?)",
//                        new Object[] {product.getName(), product.getPrice()});

        Integer autoGenKey=keyHolder.getKey().intValue();
       product.setId(autoGenKey);
         return product;
    }

    @Override
    public Product deleteProduct(Integer id) {
        jdbcTemplate.update("delete form product_table where id=?", id);
        return null;
    }

    @Override
    public Product updateProduct(Integer id, Product product) {
        jdbcTemplate.update("update product_table set price=? where id=?",
                new Object[] {product.getPrice(), id});
        return null;
    }
}
