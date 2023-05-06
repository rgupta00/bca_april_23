package com.productapp.config;

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
    public DriverManagerDataSource driverManagerDataSource(){
        DriverManagerDataSource dsMgr=new DriverManagerDataSource();
        dsMgr.setDriverClassName(environment.getProperty("jdbc.driverName"));
        dsMgr.setUsername(environment.getProperty("jdbc.username"));
        dsMgr.setPassword(environment.getProperty("jdbc.password"));
        dsMgr.setUrl(environment.getProperty("jdbc.url"));
        return  dsMgr;
    }
}
