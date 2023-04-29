package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

//        Map<String, Object> map=new HashMap<>();
//        map.put("foo", new Car());
//        map.put("bar", new CeatTyre());
//
//        Car car=map.get("foo");//upcasting and downcasting
//        CeatTyre tyre= map.get("bar");

        //BeanFactory vs ApplicationContext
       // BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("demo.xml"));

        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");

        Car car=(Car)ctx.getBean("foo");

        car.move();

//        Car car = new Car();
//        car.setCarName("tata");
//        car.setTyre(new CeatTyre());//manual DI
//        car.move();
    }
}
