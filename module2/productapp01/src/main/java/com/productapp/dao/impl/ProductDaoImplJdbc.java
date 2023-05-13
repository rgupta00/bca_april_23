package com.productapp.dao.impl;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDaoImplJdbc implements ProductDao {

    private DataSource dataSource;

    @Autowired
    public ProductDaoImplJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products=new ArrayList<>();
        Product product=null;
        try{
            Connection connection=dataSource.getConnection();
            PreparedStatement psmt=connection.prepareStatement("select * from product");
            ResultSet rs=psmt.executeQuery();
            while (rs.next()){
                product=Product.builder().id(rs.getInt(1))
                                .name(rs.getString(2))
                                 .price(rs.getBigDecimal(3))
                                .build();
                products.add(product);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }
}








