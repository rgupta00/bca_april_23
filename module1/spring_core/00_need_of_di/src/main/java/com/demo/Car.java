package com.demo;
//Car class is resp for managing its own dep :(
//Car should get its dep form outside :)
public class Car {
    private String carName;
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
