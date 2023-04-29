package com.demo.app;

public class Foo {
    private String message;

    public Foo(){
        System.out.println("ctr of foo");
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
