package com.skillstorm.springsecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springsecurity.models.Director;
import com.skillstorm.springsecurity.repositories.DirectorRepository;

@Service
public class DirectorService {
    
    @Autowired
    DirectorRepository repository;

    public List<Director> findAllDirectors() {
        return repository.findAll();
    }

    public Director saveDirector(Director director) {
        return repository.save(director);
    }

}
