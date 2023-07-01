package com.weatherclient.controller;

import com.weatherclient.service.WeatherClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceClientController {
    @Autowired
    private WeatherClientService weatherClientService;

    @GetMapping(path = "weatherclient/{temp}")
    public String weatherClient(@PathVariable int temp){
        return "client :"+  weatherClientService.getWeatherInfo(temp);
    }

}
