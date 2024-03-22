package com.skillstorm.springaop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springaop.models.Director;
import com.skillstorm.springaop.repositories.DirectorRepository;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository repository;

    public Director saveDirector(Director director) {
        return repository.save(director);
    }
    
}
