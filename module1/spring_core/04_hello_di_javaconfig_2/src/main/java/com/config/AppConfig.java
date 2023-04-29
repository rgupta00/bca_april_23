package com.config;

import com.demo.Car;
import com.demo.CeatTyre;
import com.demo.MrfTyre;
import com.demo.Tyre;
import org.springframework.context.annotation.*;

@Configuration// it means this class used by container to bootrap the application
@ComponentScan(basePackages = {"com.demo"})
 public class AppConfig {

    @Profile("dev")
    @Bean(name = "tyre1")
    public Tyre getTyre(){
        return new MrfTyre();
    }
    @Profile("test")
    @Bean(name = "tyre2")
    public Tyre getTyre2(){
        return new CeatTyre();
    }

    @Bean(name = "car")
     public Car car(Tyre tyre){
        Car car=new Car();
        car.setTyre(tyre);
        car.setCarName("abc");
        return car;
    }
}
