package com.productstore.model.dao.impl;

import com.productstore.model.dto.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product=new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getBigDecimal("price"));

        return  product;
//        Product product=new Product().builder()
//                .setId(rs.getInt("id"))
//                .setName(rs.getString("name"))
//                .setPrice(rs.getInt("price"))
//                .build();


//        return new  Product()
//                .setId(rs.getInt("id"))
//                .setName(rs.getString("name"))
//                .setPrice(rs.getInt("price"))
//                .builder()
//                .build();
    }
}
