package com.client.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class WeatherServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    int count=0;
    @CircuitBreaker(fallbackMethod ="fallbackWeatherService" , name = "weatherservice")
    public String callWeatherService( int temp){
        System.out.println("------------service is called---------- "+ ++ count+" "+ LocalDateTime.now());
        return restTemplate.getForObject("http://localhost:8081/weather/"+temp, String.class);
    }
    public String fallbackWeatherService(Exception e){
        return "ok ok";
    }
}
