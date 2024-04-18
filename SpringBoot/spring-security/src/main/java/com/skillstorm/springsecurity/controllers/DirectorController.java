package com.skillstorm.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springsecurity.models.Director;
import com.skillstorm.springsecurity.services.DirectorService;

@RestController
@RequestMapping("/directors")
@CrossOrigin("*")  
public class DirectorController {
    
    @Autowired
    DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> findAllDirectors() {
        List<Director> directors = directorService.findAllDirectors();

        return new ResponseEntity<List<Director>>(directors, HttpStatus.OK);
    }
    
}
