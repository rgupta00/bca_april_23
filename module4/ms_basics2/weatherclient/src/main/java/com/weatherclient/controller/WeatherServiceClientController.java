package com.weatherclient.controller;

import com.weatherclient.service.WeatherClientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceClientController {
    @Autowired
    private WeatherClientService weatherClientService;
    @CircuitBreaker(fallbackMethod = "weatherClientFallback", name = "weatherservice")
    @GetMapping(path = "weatherclient/{temp}")
    public String weatherClient(@PathVariable int temp){
        return "client :"+  weatherClientService.getWeatherInfo(temp);
    }

    public String weatherClientFallback(Exception ex){
        ex.printStackTrace();
        return "weather is ok";
    }

}
