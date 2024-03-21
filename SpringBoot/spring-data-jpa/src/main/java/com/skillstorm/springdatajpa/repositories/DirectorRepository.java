package com.skillstorm.springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.springdatajpa.models.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    
}
