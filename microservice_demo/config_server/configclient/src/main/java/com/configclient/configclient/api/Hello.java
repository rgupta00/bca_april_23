package com.configclient.configclient.api;

import com.configclient.configclient.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class Hello {

    @Value("${spring.datasource.url}")
    private  String url;

    @Autowired
    private DbConfig dbConfig;

    @GetMapping("hello")
    public String sayHello(){
        System.out.println(dbConfig.getUrl());
        return "hello "+ url;
    }
}
