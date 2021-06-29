package com.infoplus.hopital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {
    @GetMapping("/")
    public  String helloJenkins(){
        return "Hello Jenkins";
    }
}
