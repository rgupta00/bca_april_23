package com.productapp.dao.impl;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
@Primary
public class ProductDaoImplJdbcTemplate implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("select * from product", ( rs,  rowNum) ->{
                return Product.builder().id(rs.getInt(1))
                        .name(rs.getString(2))
                        .price(rs.getBigDecimal(3))
                        .build();
        });
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }
}
