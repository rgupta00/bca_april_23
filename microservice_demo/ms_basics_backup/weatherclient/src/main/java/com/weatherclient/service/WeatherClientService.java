package com.weatherclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherClientService {

    @Autowired
    private RestTemplate restTemplate;

    public String getWeatherInfo(int temp){
        return restTemplate.getForObject("http://localhost:8081/weatherinfo/"+ temp,
                String.class);
    }
}
