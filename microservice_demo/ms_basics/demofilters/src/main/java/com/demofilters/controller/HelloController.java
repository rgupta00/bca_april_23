package com.demofilters.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "hello")
    public String hello(){
        return "hello endpoint";
    }

    @GetMapping(path = "hello2")
    public String hello2(){
        return "hello2 endpoint";
    }

    @GetMapping(path = "hello2/pqr")
    public String hello2Nested2(){
        return "hello2/pqr endpoint";
    }

    @GetMapping(path = "hello2/bca")
    public String hello2Nested(){
        return "hello2/bca endpoint";
    }

    @GetMapping(path = "hello3")
    public String hello3(){
        return "hello3 endpoint";
    }

}
