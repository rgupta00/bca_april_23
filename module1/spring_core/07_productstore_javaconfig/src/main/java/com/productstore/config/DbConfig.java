package com.productstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DbConfig {

    @Autowired
    private Environment environment;
    @Bean
    public DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setUrl(environment.getProperty("jdbc.url"));
        ds.setUsername(environment.getProperty("jdbc.username"));
        ds.setPassword(environment.getProperty("jdbc.password"));
        ds.setDriverClassName(environment.getProperty("jdbc.driver"));
        return ds;
    }
}
