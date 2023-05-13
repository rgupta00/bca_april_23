package com.productapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DbConfig {
    //configure datasource
    @Value("${spring.datasource.username}")
    private  String userName;

    @Value("${spring.datasource.password}")
    private  String password;

    @Value("${spring.datasource.url}")
    private  String url;

    @Value("${spring.datasource.driverClassName}")
    private  String driverClassName;

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource=
                new DriverManagerDataSource();
        dataSource.setPassword(password);
        dataSource.setUsername(userName);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

}

