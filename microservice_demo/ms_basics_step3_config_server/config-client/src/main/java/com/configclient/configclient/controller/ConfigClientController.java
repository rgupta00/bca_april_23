package com.configclient.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${spring.datasource.url: not found}")
    private  String url;

    @GetMapping(path="geturl")
    public String getUrl(){
        return url;
    }
}


