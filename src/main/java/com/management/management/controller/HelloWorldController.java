package com.management.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(value = "/api/helloWorld")
    //해당 api의 테스트값
    public String helloWorld() {
        return "HelloWorld";
    }
}