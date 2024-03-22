package com.skillstorm.springaop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springaop.models.Director;
import com.skillstorm.springaop.models.Movie;
import com.skillstorm.springaop.repositories.MovieRepository;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    DirectorService directorService;
    
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();       //calls the findAll() in JpaRepository
    }

    public Movie findMovieById(int id) {

        //if our database has a movie with a matching id, return it
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isPresent()) {     // isPresent() checks if the optional returned the object
            return movie.get();     // get() will retrieve the object
        }
        //otherwise return null
        return null;
    }

    public List<Movie> findMoviesByRating(int rating) {
        Optional<List<Movie>> movies = movieRepository.findAllByRatingGreaterThanEqual(rating);

        if(movies.isPresent()) {
            return movies.get();
        }
        return null;
    }

    public Movie saveMovie(Movie movie) {

        /*
         * save() performs an isNew() checks using your primary key
         * 
         *      comes OOTB with JpaRepository
         */

        Director directorWithId = directorService.saveDirector(movie.getDirector());
        movie.setDirector(directorWithId);
        return movieRepository.save(movie);
    }

    public int updateTitle(Movie movie, String newTitle) {
        return movieRepository.updateMovieTitle(movie.getId(), newTitle);
    }

    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }


}
