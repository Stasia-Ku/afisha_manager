package ru.netology.manager;

import ru.netology.domain.Movie;
import java.util.*;

public class MovieManager {
    private Movie[] movies = new Movie[0];

    public void addMovie(String id, String imageUrl, String name, String genre) {
        Movie newMovie = new Movie(id, imageUrl, name, genre);

        Movie[] newArray = Arrays.copyOf(this.movies, this.movies.length + 1);
        newArray[this.movies.length] = newMovie;
        this.movies = newArray;
    }

    public Movie[] getLastMovies(int countOfMovies) {
        if (countOfMovies > this.movies.length) { countOfMovies = this.movies.length; }

        Movie[] result = new Movie[countOfMovies];

        for(int i = this.movies.length - 1; i >= this.movies.length - countOfMovies; i--) {
            result[this.movies.length - i - 1] = movies[i];
        }

        return result;
    }
}
