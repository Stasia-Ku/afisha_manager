package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;

    public MovieManager (MovieRepository repository) {
        this.repository = repository;
    }

    public void addMovie(String id, String imageUrl, String name, String genre) {
        Movie newMovie = new Movie(id, imageUrl, name, genre);
        repository.save(newMovie);
    }

    public Movie[] getLastMovies(int countOfMovies) {
        int length = this.repository.findAll().length;
        if (countOfMovies > length) { countOfMovies = length; }

        Movie[] result = new Movie[countOfMovies];

        for(int i = length - 1; i >= length - countOfMovies; i--) {
            result[length - i - 1] = this.repository.findAll()[i];
        }

        return result;
    }
}
