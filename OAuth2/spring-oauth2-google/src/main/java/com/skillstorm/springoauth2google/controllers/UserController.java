package com.skillstorm.springoauth2google.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!";
    }
    
}
