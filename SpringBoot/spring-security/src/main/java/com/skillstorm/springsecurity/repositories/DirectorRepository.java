package com.skillstorm.springsecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.springsecurity.models.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{
    
}
