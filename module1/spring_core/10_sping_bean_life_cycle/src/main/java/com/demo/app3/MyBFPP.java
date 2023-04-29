package com.demo.app3;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBFPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition bd=beanFactory.getBeanDefinition("foo");
        MutablePropertyValues mv=bd.getPropertyValues();
        mv.addPropertyValue("message","new foo value");
        System.out.println("bean factory is loaded the def of all the beans");
    }
}
