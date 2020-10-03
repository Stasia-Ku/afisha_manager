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
public class CartManagerTestNonEmpty {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
    private Movie movie1 = new Movie("1", 1, "first", 1, 1);
    private Movie movie2 = new PurchaseItem(2, 2, "second", 1, 1);
    private Movie movie3 = new PurchaseItem(3, 3, "third", 1, 1);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        // настройка заглушки
        PurchaseItem[] returned = new PurchaseItem[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        PurchaseItem[] expected = new PurchaseItem[]{third, second};
        PurchaseItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        PurchaseItem[] returned = new PurchaseItem[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};
        PurchaseItem[] actual = manager.getAll();

        assertArrayEquals(expected, actual);
        // удостоверяемся, что заглушка была вызвана с нужным значением
        // но это уже проверка "внутренней" реализации
        verify(repository).removeById(idToRemove);
    }
}