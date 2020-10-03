package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MovieManagerTestNonEmpty {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
    private Movie movie1 = new Movie("1", "/image/1.jpg", "MovieName", "Comedy");
    private Movie movie2 = new Movie("2", "/image/2.jpg", "MovieName2", "Comedy");
    private Movie movie3 = new Movie("3", "/image/3.jpg", "MovieName3", "Comedy");
    private Movie movie4 = new Movie("4", "/image/4.jpg", "MovieName4", "Comedy");
    private Movie movie5 = new Movie("5", "/image/5.jpg", "MovieName5", "Comedy");
    private Movie movie6 = new Movie("6", "/image/6.jpg", "MovieName6", "Comedy");
    private Movie movie7 = new Movie("7", "/image/7.jpg", "MovieName7", "Comedy");
    private Movie movie8 = new Movie("8", "/image/8.jpg", "MovieName8", "Comedy");
    private Movie movie9 = new Movie("9", "/image/9.jpg", "MovieName9", "Comedy");
    private Movie movie10 = new Movie("10", "/image/10.jpg", "MovieName10", "Comedy");

    @BeforeEach
    public void setUp() {
        manager.addMovie(movie1.getId(), movie1.getImageUrl(), movie1.getName(), movie1.getGenre());
        manager.addMovie(movie2.getId(), movie2.getImageUrl(), movie2.getName(), movie2.getGenre());
        manager.addMovie(movie3.getId(), movie3.getImageUrl(), movie3.getName(), movie3.getGenre());
        manager.addMovie(movie4.getId(), movie4.getImageUrl(), movie4.getName(), movie4.getGenre());
        manager.addMovie(movie5.getId(), movie5.getImageUrl(), movie5.getName(), movie5.getGenre());
        manager.addMovie(movie6.getId(), movie6.getImageUrl(), movie6.getName(), movie6.getGenre());
        manager.addMovie(movie7.getId(), movie7.getImageUrl(), movie7.getName(), movie7.getGenre());
        manager.addMovie(movie8.getId(), movie8.getImageUrl(), movie8.getName(), movie8.getGenre());
        manager.addMovie(movie9.getId(), movie9.getImageUrl(), movie9.getName(), movie9.getGenre());
        manager.addMovie(movie10.getId(), movie10.getImageUrl(), movie10.getName(), movie10.getGenre());
    }

    @Test
    public void shouldGetLastMovies() {
        String idToRemove = "10";

        Movie[] returned = new Movie[]{movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        Movie[] expected = new Movie[]{movie5, movie6, movie7, movie8, movie9};
        Movie[] actual = manager.getLastMovies(5);
        assertArrayEquals(expected, actual);

        verify(repository).removeById(idToRemove);
    }
}
