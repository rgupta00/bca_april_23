package com.demo;

import org.springframework.context.ApplicationContext;
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

        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");

        Car car=(Car)ctx.getBean("foo");

        car.move();

//        Car car = new Car();
//        car.setCarName("tata");
//        car.setTyre(new CeatTyre());//manual DI
//        car.move();
    }
}
