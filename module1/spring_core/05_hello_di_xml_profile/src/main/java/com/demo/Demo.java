package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

        ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");

        Car car=(Car)ctx.getBean("foo");

        car.move();

    }
}
