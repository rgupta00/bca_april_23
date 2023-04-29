package com.demo;

import com.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        Car car=(Car)ctx.getBean("car");
        car.move();

        Car car2=(Car)ctx.getBean("car");
        car2.move();

    }
}
