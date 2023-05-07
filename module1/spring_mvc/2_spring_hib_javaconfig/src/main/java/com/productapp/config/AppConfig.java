package com.productapp.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.productapp"})
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)//proxyTargetClass = true?
@Import(DbConfig.class)
public class AppConfig {
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean=
                new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(new String[]{"com.productapp.model.entities"});
        localSessionFactoryBean.setHibernateProperties( getProperties());
        return localSessionFactoryBean;
    }

    //helper method
    private Properties  getProperties(){
        Properties properties=new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");

        return properties;
    }
    @Bean
    public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
