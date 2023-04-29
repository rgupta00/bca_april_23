package com.demo;

public class Demo {
    public static void main(String[] args) {
       Car car=new Car(); //:(
       car.setTyre(new MrfTyre());
       car.setCarName("abc");
       car.move();
    }
}
