package ru.netology.repository;

import ru.netology.domain.Movie;

import java.util.*;

public class MovieRepository {
    private Movie[] movies;

    public MovieRepository() {
        movies = new Movie[0];
    }

    public Movie[] findAll() {
        return this.movies;
    }

    public void save(Movie newMovie){
        Movie[] newArray = Arrays.copyOf(this.movies, this.movies.length + 1);
        newArray[this.movies.length] = newMovie;
        this.movies = newArray;
    }

    public Movie findById(String id){
        for(int i = 0; i < this.movies.length; i++) {
            if(this.movies[i].getId() == id) {
                return this.movies[i];
            }
        }
        return null;
    }

    public void removeById(String id){
        Movie[] result = new Movie[this.movies.length - 1];
        int index = 0;

        for(int i = 0; i < this.movies.length; i++) {
            if(this.movies[i].getId() != id) {
                result[index] = this.movies[i];
                index++;
            }
        }

        this.movies = result;
    }

    public void removeAll() {
        this.movies = null;
    }
}
