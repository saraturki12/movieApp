package com.project.movie.Service;

import com.project.movie.model.Movie;
import com.project.movie.repositroy.movierepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private movierepository movieRepository1;

    public List<Movie> getAllMovies() {
        return movieRepository1.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository1.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository1.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Movie existingMovie = movieRepository1.findById(id).orElse(null);
        if (existingMovie == null) {
            return null; // Handle not found
        }
        // Update the existing movie with the new data
        existingMovie.setTitle(updatedMovie.getTitle());
        // ... Update other fields
        return movieRepository1.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository1.deleteById(id);
    }
}

