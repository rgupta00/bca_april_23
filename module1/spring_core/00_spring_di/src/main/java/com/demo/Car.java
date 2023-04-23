package com.demo;
//Car class is resp for managing its own dep :(
//Car should get its dep form outside :)
public class Car {
    private String carName="tata";
    private MrfTyre tyre=new MrfTyre();

    public void move(){
        tyre.rotate();
        System.out.println("moving in a car "+ carName);
    }
}
