package com.weatherclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherClientService {
//     dont support load balancing              load balancing
//    DiscoveryClient                   vs LoadBalanceClient vs RestTemplate
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//
    @Autowired
    private RestTemplate restTemplate;

    public String getWeatherInfo(int temp){
      //  ServiceInstance instance=loadBalancerClient.choose("WEATHER-SERVICE");

       // String uri=instance.getUri().toString();
       // return restTemplate.getForObject(uri+"/wservice/weatherinfo/"+ temp, String.class);
       return restTemplate.getForObject("http://WEATHER-SERVICE/wservice/weatherinfo/"+ temp, String.class);
    }
}










