package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    @Test
    void shouldFindAll() {
        Movie movie1 = new Movie("1","/image/1.jpg", "MovieName", "Comedy");
        Movie movie2 = new Movie("2","/image/2.jpg", "MovieName2", "Comedy");
        Movie movie3 = new Movie("3","/image/3.jpg", "MovieName3", "Comedy");

        MovieRepository repository = new MovieRepository();
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);

        Movie[] result = repository.findAll();
        Movie[] expected = new Movie[]{movie1, movie2, movie3};

        assertArrayEquals(result, expected);
    }

    @Test
    void shouldSave() {
        Movie movie = new Movie("1","/image/1.jpg", "MovieName", "Comedy");

        MovieRepository repository = new MovieRepository();
        repository.save(movie);

        Movie[] result = repository.findAll();
        Movie[] expected = new Movie[]{movie};

        assertArrayEquals(result, expected);
    }

    @Test
    void shouldFindByIdExists() {
        Movie movie1 = new Movie("1","/image/1.jpg", "MovieName", "Comedy");
        Movie movie2 = new Movie("2","/image/2.jpg", "MovieName2", "Comedy");
        Movie movie3 = new Movie("3","/image/3.jpg", "MovieName3", "Comedy");

        MovieRepository repository = new MovieRepository();
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);

        Movie result = repository.findById("2");

        assertEquals(result, movie2);
    }

    @Test
    void shouldFindByIdNotExists() {
        Movie movie1 = new Movie("1","/image/1.jpg", "MovieName", "Comedy");
        Movie movie2 = new Movie("2","/image/2.jpg", "MovieName2", "Comedy");
        Movie movie3 = new Movie("3","/image/3.jpg", "MovieName3", "Comedy");

        MovieRepository repository = new MovieRepository();
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);

        Movie result = repository.findById("0");

        assertEquals(result, null);
    }

    @Test
    void shouldRemoveById() {
        Movie movie1 = new Movie("1","/image/1.jpg", "MovieName", "Comedy");
        Movie movie2 = new Movie("2","/image/2.jpg", "MovieName2", "Comedy");
        Movie movie3 = new Movie("3","/image/3.jpg", "MovieName3", "Comedy");

        MovieRepository repository = new MovieRepository();
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);

        repository.removeById("2");
        Movie[] result = repository.findAll();
        Movie[] expected = new Movie[]{movie1, movie3};

        assertArrayEquals(result, expected);
    }

    @Test
    void shouldRemoveAll() {
        Movie movie1 = new Movie("1","/image/1.jpg", "MovieName", "Comedy");
        Movie movie2 = new Movie("2","/image/2.jpg", "MovieName2", "Comedy");
        Movie movie3 = new Movie("3","/image/3.jpg", "MovieName3", "Comedy");

        MovieRepository repository = new MovieRepository();
        repository.save(movie1);
        repository.save(movie2);
        repository.save(movie3);

        repository.removeAll();
        Movie[] result = repository.findAll();

        assertArrayEquals(result, null);
    }
}