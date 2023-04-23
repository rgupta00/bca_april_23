package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Car class is resp for managing its own dep :(
//Car should get its dep form outside :)
/*
<bean id="foo" class="com.demo.Car" >

    </bean>

 */
@Service(value = "car")
//@Component(value = "car")
public class Car {
    // <property name="carName" value="tata"/>
    @Value("tata")
    private String carName;
    //autowire="byType"

    @Autowired
    private Tyre tyre;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public void move(){
        tyre.rotate();
        System.out.println("moving in a car "+ carName);
    }
}
