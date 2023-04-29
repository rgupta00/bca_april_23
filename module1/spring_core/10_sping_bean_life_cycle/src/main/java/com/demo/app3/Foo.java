package com.demo.app3;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo {
    private String message;

    public Foo(){
        System.out.println("ctr of foo");
    }
    public String getMessage() {
        return message;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct wala");
    }

    public void setMessage(String message) {
        System.out.println("setMessage() is called");
        this.message = message;
    }
    public void doWork(){
        System.out.println("working");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("preDestory wala");
    }

}
