package com.weatherclient.controller;

import com.weatherclient.service.WeatherClientService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.IntStream;

@RestController
public class WeatherServiceClientController {
    @Autowired
    private WeatherClientService weatherClientService;

//    @GetMapping("hello")
//    public String hello(@RequestHeader(name = "weatherappfilter1") String weatherappfilter){
//        return "hello :"+weatherappfilter;
//    }

    @CircuitBreaker(fallbackMethod = "fallBackLogic", name = "weatherservice")
    @GetMapping(path = "weatherclient/{temp}")
    public String weatherClient(@PathVariable int temp){
        return "client :"+  weatherClientService.getWeatherInfo(temp);
    }
    public String fallBackLogic(Exception e){
        System.out.println("****************************");
        System.out.println(e);
        System.out.println("****************************");
        return "weather is ok ok";
    }

}
