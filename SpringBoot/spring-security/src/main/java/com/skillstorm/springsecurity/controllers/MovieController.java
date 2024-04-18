package com.skillstorm.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springsecurity.services.MovieService;

import jakarta.validation.Valid;

import com.skillstorm.springsecurity.models.Movie;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")                    // specifies who is allowed to make requests, it defaults to allowing everyone
public class MovieController {
    

    @Autowired
    MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> movies = movieService.findAllMovies();

        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable int id) {
        Movie movie = movieService.findMovieById(id);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }


    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Movie>> findMoviesByRating(@PathVariable int rating) {

        List<Movie> movies = movieService.findMoviesByRating(rating);

        if(movies == null) {
            return ResponseEntity.noContent().build();
        }

        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);

    }

    /*
     * @Valid will make sure the incoming object meets all constraints defined on the model
     * 
     *      gives the error back here rather than when the record tries to be saved
     * 
     * 
     *      aka JSR-303 validation
     * 
     */

    @PostMapping("/movie") 
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {         
        
        // insert the director that is provided with the movie - handle this in the service
        Movie newMovie = movieService.saveMovie(movie);
        return new ResponseEntity<Movie>(newMovie, HttpStatus.CREATED);
    }


    @PutMapping("/movie") 
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        
        Movie newMovie = movieService.saveMovie(movie);
        return new ResponseEntity<Movie>(newMovie, HttpStatus.OK);
    }

    @PutMapping("/movie/updateTitle") 
    public ResponseEntity<Integer> updateMovieTitle(@RequestBody Movie movie, @RequestParam String newTitle) {
        
        int updated = movieService.updateTitle(movie, newTitle);
        return new ResponseEntity<Integer>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/movie") 
    public ResponseEntity<Movie> deleteMovie(@RequestBody Movie movie) {
        
        movieService.deleteMovie(movie);
        return ResponseEntity.noContent().build();
    }

}