package com.demo;

import org.springframework.stereotype.Component;

//<bean id="tyre1" class="com.demo.MrfTyre"/>
@Component(value = "tyre1")
public class MrfTyre implements Tyre{
    public  void rotate(){
        System.out.println("mrf tyre");
    }
}
