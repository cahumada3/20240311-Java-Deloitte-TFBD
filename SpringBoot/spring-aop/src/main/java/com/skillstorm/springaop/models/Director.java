package com.skillstorm.springaop.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity                             //tells jpa that this class relates to a db table
@Table(name = "DIRECTORS")          //tells jpa WHICH db table - name isnt needed if your class name is the same as the db table name
public class Director {

    @Id                                                     //specifies primary key
    @Column                                                 //says this a db column
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //specifies it uses AUTO_INCREMENT
    private int id;

    @Column(name = "first_name")    // in schema we used first_name so we will have to add that name to our column
    private String firstName;

    @Column(name = "last_name") 
    private String lastName;

    @OneToMany(targetEntity = Movie.class, mappedBy = "director")       //mappedBy is the name of the JAVA VARIABLE in the other object
    private Set<Movie> movies;

    public Director() {
    }

    public Director(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Director(String firstName, String lastName, Set<Movie> movies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = movies;
    }

    public Director(int id, String firstName, String lastName, Set<Movie> movies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((movies == null) ? 0 : movies.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Director other = (Director) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (movies == null) {
            if (other.movies != null)
                return false;
        } else if (!movies.equals(other.movies))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Director [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    
    
    
}
