package com.skillstorm.springsecurity.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springsecurity.models.AppUser;
import com.skillstorm.springsecurity.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/private_info")
    public String privateInfo(Principal principal, Authentication authentication) {

        /**
         * can use Principal and authentication object to get info about the request 
         *      pull data from the SecurityContext
         *      principal is the user
         *      
         */

        long count = userService.countAllUsers();   // requires admin privileges

        //return "Some private data : " + principal.getName() + "; userCount: " + count;
        return "Some private data : " + principal.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody AppUser user) {
        userService.register(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<Void> registerAdmin(@RequestBody AppUser user) {
        userService.registerAdmin(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
}
