package com.demo;

import com.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

//        Map<String, Object> map=new HashMap<>();
//        map.put("foo", new Car());
//        map.put("bar", new CeatTyre());
//
//        Car car=map.get("foo");//upcasting and downcasting
//        CeatTyre tyre= map.get("bar");

//        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");

        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Car car=(Car)ctx.getBean("car");
        car.move();

//        Car car = new Car();
//        car.setCarName("tata");
//        car.setTyre(new CeatTyre());//manual DI
//        car.move();
    }
}
