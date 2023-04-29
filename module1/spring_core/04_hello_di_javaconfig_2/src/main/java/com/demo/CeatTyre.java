package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class CeatTyre implements Tyre{
    public  void rotate(){
        System.out.println("ceat tyre");
    }
}
