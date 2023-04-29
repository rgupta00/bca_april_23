package com.demo.app2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean, DisposableBean {
    private String message;

    public Foo(){
        System.out.println("ctr of foo");
    }
    public String getMessage() {
        return message;
    }

    public  void myInit(){
        System.out.println("myInit xml wala is called");
    }
    public void setMessage(String message) {
        System.out.println("setMessage() is called");
        this.message = message;
    }
    public void doWork(){
        System.out.println("working");
    }

    public  void myDestory(){
        System.out.println("myDestory xml wala is called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destory of DisposableBean is called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet of InitializingBean is called");
    }
}
