package com.productstore.model.dao.impl;

import com.productstore.model.dao.ProductDao;
import com.productstore.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.lang.annotation.Repeatable;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
@Primary
public class ProductDaoImplJdbc implements ProductDao {

    private DataSource dataSource;

    @Autowired
    public ProductDaoImplJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products=new ArrayList<>();
        //:( rs to object ==> ORM
       try{
           Connection connection=dataSource.getConnection();
           PreparedStatement pstmt=connection.prepareStatement("select * from product_table");

           ResultSet rs=pstmt.executeQuery();
           while (rs.next()){
               products.add(new Product(rs.getInt(1), rs.getString(2),rs.getBigDecimal(3)));
           }
       }catch (SQLException ex){
           ex.printStackTrace();
       }

       return  products;
    }

    @Override
    public Product getById(Integer id) {
        return  null;

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
