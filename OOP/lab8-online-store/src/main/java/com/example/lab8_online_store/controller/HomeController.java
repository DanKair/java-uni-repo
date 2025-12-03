package com.example.lab8_online_store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    // Get method in the url: localhost/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello from my Spring Boot app!";
    }

}
