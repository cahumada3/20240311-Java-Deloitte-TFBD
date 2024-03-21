package com.skillstorm.springdatajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springdatajpa.models.Movie;
import com.skillstorm.springdatajpa.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();       //calls the findAll() in JpaRepository
    }
}
