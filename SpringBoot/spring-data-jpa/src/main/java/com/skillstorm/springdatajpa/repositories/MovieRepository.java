package com.skillstorm.springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.springdatajpa.models.Movie;

/*
 * repositories talk to your database
 *      no business logic
 * 
 *      needs to be an interface that extends an existing repository class
 *          CrudRepository                  - crud operations
 *          PagingAndSortingRepository      - extends the CrudRepository and includes methods for pagination and sorting
 *          JpaRepository                   - extends PagingAndSortingRepository plus lots of extras
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /*
     * the point of JPA is that you don't have to write basic queries anymore
     * 
     * jpa comes with many methods out of the box
     *      save, findAll, findById, delete, deleteById, deleteAll, etc.
     * 
     * you can also write your own methods
     *      jpa will convert the nmae of your method into a JPQL query
     *      https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
     * 
     */
    
}
