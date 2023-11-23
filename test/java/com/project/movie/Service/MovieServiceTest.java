package com.project.movie.Service;

import com.project.movie.model.Movie;
import com.project.movie.repositroy.movierepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MovieServiceTest {
movierepository movierepository1;
 MovieService  movieService;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllMovies() {
        // Mock the behavior of the movieRepository to return some test data
        Movie movie1 = new Movie(1l,"Movie 2",2020,60,"Director1");
        Movie movie2 = new Movie(2L, "Movie 2", 2021,120,"Director 2");
        List<Movie> movies = Arrays.asList(movie1, movie2);

        when(movierepository1.findAll()).thenReturn(movies);

        // Call the service method
        List<Movie> result = movieService.getAllMovies();

        // Assert that the result matches the expected data
        assertEquals(2, result.size());
        assertEquals("Movie 1", result.get(0).getTitle());
        assertEquals("Movie 2", result.get(1).getTitle());
    }
    @Test
    public void testGetMovieById() {
        // Mock the behavior of the movieRepository to return a movie with ID 1
        Movie movie = new Movie(1l,"Movie 2",2020,60,"Director1");
        when(movierepository1.findById(1L)).thenReturn(Optional.of(movie));

        // Call the service method to get a movie by ID
        Movie result = movieService.getMovieById(1L);

        // Assert that the result matches the expected movie
        assertEquals("Movie 1", result.getTitle());
        assertEquals("Director 1", result.getDirector());
        assertEquals(2020, result.getReleaseYear());
    }
}







