package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieManagerTest {

    @Test
    void addMovieTest() {
        Movie movie = new Movie("1","/image/1.jpg", "MovieName", "Comedy");
        MovieManager movieManager = new MovieManager();

        movieManager.addMovie(movie.getId(), movie.getImageUrl(), movie.getName(), movie.getGenre());
        movieManager.getLastMovies(1);

        assertEquals(movieManager.getLastMovies(1)[0].getId(), movie.getId());
        assertEquals(movieManager.getLastMovies(1)[0].getImageUrl(), movie.getImageUrl());
        assertEquals(movieManager.getLastMovies(1)[0].getName(), movie.getName());
        assertEquals(movieManager.getLastMovies(1)[0].getGenre(), movie.getGenre());
    }

    @Test
    void getLastMoviesNormalTest() {
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("1", "/image/1.jpg", "MovieName", "Comedy");
        movieManager.addMovie("2", "/image/2.jpg", "MovieName2", "Comedy");
        movieManager.addMovie("3", "/image/3.jpg", "MovieName3", "Comedy");
        movieManager.addMovie("4", "/image/4.jpg", "MovieName4", "Comedy");
        movieManager.addMovie("5", "/image/5.jpg", "MovieName5", "Comedy");
        movieManager.addMovie("6", "/image/6.jpg", "MovieName6", "Comedy");
        movieManager.addMovie("7", "/image/7.jpg", "MovieName7", "Comedy");
        movieManager.addMovie("8", "/image/8.jpg", "MovieName8", "Comedy");
        movieManager.addMovie("9", "/image/9.jpg", "MovieName9", "Comedy");
        movieManager.addMovie("10", "/image/10.jpg", "MovieName10", "Comedy");

        Movie[] lastMovies;

        lastMovies = movieManager.getLastMovies(10);

        assertEquals(lastMovies[0].getId(), "10");
        assertEquals(lastMovies[0].getImageUrl(), "/image/10.jpg");
        assertEquals(lastMovies[0].getName(), "MovieName10");
        assertEquals(lastMovies[0].getGenre(), "Comedy");

        assertEquals(lastMovies[1].getId(), "9");
        assertEquals(lastMovies[1].getImageUrl(), "/image/9.jpg");
        assertEquals(lastMovies[1].getName(), "MovieName9");
        assertEquals(lastMovies[1].getGenre(), "Comedy");

        assertEquals(lastMovies[2].getId(), "8");
        assertEquals(lastMovies[2].getImageUrl(), "/image/8.jpg");
        assertEquals(lastMovies[2].getName(), "MovieName8");
        assertEquals(lastMovies[2].getGenre(), "Comedy");

        assertEquals(lastMovies[3].getId(), "7");
        assertEquals(lastMovies[3].getImageUrl(), "/image/7.jpg");
        assertEquals(lastMovies[3].getName(), "MovieName7");
        assertEquals(lastMovies[3].getGenre(), "Comedy");

        assertEquals(lastMovies[4].getId(), "6");
        assertEquals(lastMovies[4].getImageUrl(), "/image/6.jpg");
        assertEquals(lastMovies[4].getName(), "MovieName6");
        assertEquals(lastMovies[4].getGenre(), "Comedy");

        assertEquals(lastMovies[5].getId(), "5");
        assertEquals(lastMovies[5].getImageUrl(), "/image/5.jpg");
        assertEquals(lastMovies[5].getName(), "MovieName5");
        assertEquals(lastMovies[5].getGenre(), "Comedy");

        assertEquals(lastMovies[6].getId(), "4");
        assertEquals(lastMovies[6].getImageUrl(), "/image/4.jpg");
        assertEquals(lastMovies[6].getName(), "MovieName4");
        assertEquals(lastMovies[6].getGenre(), "Comedy");

        assertEquals(lastMovies[7].getId(), "3");
        assertEquals(lastMovies[7].getImageUrl(), "/image/3.jpg");
        assertEquals(lastMovies[7].getName(), "MovieName3");
        assertEquals(lastMovies[7].getGenre(), "Comedy");

        assertEquals(lastMovies[8].getId(), "2");
        assertEquals(lastMovies[8].getImageUrl(), "/image/2.jpg");
        assertEquals(lastMovies[8].getName(), "MovieName2");
        assertEquals(lastMovies[8].getGenre(), "Comedy");

        assertEquals(lastMovies[9].getId(), "1");
        assertEquals(lastMovies[9].getImageUrl(), "/image/1.jpg");
        assertEquals(lastMovies[9].getName(), "MovieName");
        assertEquals(lastMovies[9].getGenre(), "Comedy");
    }

    @Test
    void getLastMoviesOverTest() {
        MovieManager movieManager = new MovieManager();
        movieManager.addMovie("1", "/image/1.jpg", "MovieName", "Comedy");
        movieManager.addMovie("2", "/image/2.jpg", "MovieName2", "Comedy");
        movieManager.addMovie("3", "/image/3.jpg", "MovieName3", "Comedy");
        movieManager.addMovie("4", "/image/4.jpg", "MovieName4", "Comedy");
        movieManager.addMovie("5", "/image/5.jpg", "MovieName5", "Comedy");
        movieManager.addMovie("6", "/image/6.jpg", "MovieName6", "Comedy");
        movieManager.addMovie("7", "/image/7.jpg", "MovieName7", "Comedy");
        movieManager.addMovie("8", "/image/8.jpg", "MovieName8", "Comedy");
        movieManager.addMovie("9", "/image/9.jpg", "MovieName9", "Comedy");
        movieManager.addMovie("10", "/image/10.jpg", "MovieName10", "Comedy");

        Movie[] lastMovies;

        lastMovies = movieManager.getLastMovies(12);

        assertEquals(lastMovies.length, 10);

        assertEquals(lastMovies[0].getId(), "10");
        assertEquals(lastMovies[0].getImageUrl(), "/image/10.jpg");
        assertEquals(lastMovies[0].getName(), "MovieName10");
        assertEquals(lastMovies[0].getGenre(), "Comedy");

        assertEquals(lastMovies[1].getId(), "9");
        assertEquals(lastMovies[1].getImageUrl(), "/image/9.jpg");
        assertEquals(lastMovies[1].getName(), "MovieName9");
        assertEquals(lastMovies[1].getGenre(), "Comedy");

        assertEquals(lastMovies[2].getId(), "8");
        assertEquals(lastMovies[2].getImageUrl(), "/image/8.jpg");
        assertEquals(lastMovies[2].getName(), "MovieName8");
        assertEquals(lastMovies[2].getGenre(), "Comedy");

        assertEquals(lastMovies[3].getId(), "7");
        assertEquals(lastMovies[3].getImageUrl(), "/image/7.jpg");
        assertEquals(lastMovies[3].getName(), "MovieName7");
        assertEquals(lastMovies[3].getGenre(), "Comedy");

        assertEquals(lastMovies[4].getId(), "6");
        assertEquals(lastMovies[4].getImageUrl(), "/image/6.jpg");
        assertEquals(lastMovies[4].getName(), "MovieName6");
        assertEquals(lastMovies[4].getGenre(), "Comedy");

        assertEquals(lastMovies[5].getId(), "5");
        assertEquals(lastMovies[5].getImageUrl(), "/image/5.jpg");
        assertEquals(lastMovies[5].getName(), "MovieName5");
        assertEquals(lastMovies[5].getGenre(), "Comedy");

        assertEquals(lastMovies[6].getId(), "4");
        assertEquals(lastMovies[6].getImageUrl(), "/image/4.jpg");
        assertEquals(lastMovies[6].getName(), "MovieName4");
        assertEquals(lastMovies[6].getGenre(), "Comedy");

        assertEquals(lastMovies[7].getId(), "3");
        assertEquals(lastMovies[7].getImageUrl(), "/image/3.jpg");
        assertEquals(lastMovies[7].getName(), "MovieName3");
        assertEquals(lastMovies[7].getGenre(), "Comedy");

        assertEquals(lastMovies[8].getId(), "2");
        assertEquals(lastMovies[8].getImageUrl(), "/image/2.jpg");
        assertEquals(lastMovies[8].getName(), "MovieName2");
        assertEquals(lastMovies[8].getGenre(), "Comedy");

        assertEquals(lastMovies[9].getId(), "1");
        assertEquals(lastMovies[9].getImageUrl(), "/image/1.jpg");
        assertEquals(lastMovies[9].getName(), "MovieName");
        assertEquals(lastMovies[9].getGenre(), "Comedy");
    }
}