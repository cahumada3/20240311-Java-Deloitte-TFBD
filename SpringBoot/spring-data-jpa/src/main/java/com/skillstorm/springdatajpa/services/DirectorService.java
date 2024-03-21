package com.skillstorm.springdatajpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springdatajpa.models.Director;
import com.skillstorm.springdatajpa.repositories.DirectorRepository;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository repository;

    public Director saveDirector(Director director) {
        return repository.save(director);
    }
    
}
