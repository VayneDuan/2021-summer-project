package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello stringboot!!";
    }
}
