package com.sajalinghal7.jwtAuthApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping({"/hello"})
    public String getHelloWorld() {
        return "Hello World";
    }
}
