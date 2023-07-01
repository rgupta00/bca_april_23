package com.weatherservice.controller;

import com.weatherservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WeatherServiceController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping(path="weatherinfo/{temp}")
    public String getWeatherInfo(@PathVariable int temp,@RequestHeader("weatherapp") String weatherapp){
        System.out.println("################### "+ weatherapp);
        return weatherService.getWeatherInfo(temp);
    }

}
