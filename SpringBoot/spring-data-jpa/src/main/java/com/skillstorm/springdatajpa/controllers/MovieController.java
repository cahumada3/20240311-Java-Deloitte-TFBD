package com.skillstorm.springdatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springdatajpa.models.Movie;
import com.skillstorm.springdatajpa.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movie = movieService.findAllMovies();

        return new ResponseEntity<List<Movie>>(movie, HttpStatus.OK);
    }
    
}
