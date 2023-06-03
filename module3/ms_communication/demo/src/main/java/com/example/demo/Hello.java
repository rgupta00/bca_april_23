package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("hello")
    public String hello(){
        return "spring boot on tomcat!";
    }
}
