package com.project.movie.cotroller.impl;

import com.project.movie.dto.MovieDto;
import com.project.movie.model.Movie;
import com.project.movie.repositroy.ActionMovieRepository;
import com.project.movie.repositroy.ComedyMovieRepository;
import com.project.movie.repositroy.movierepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private movierepository movieRepository;

    @Autowired
    private ActionMovieRepository actionMovieRepository;

    @Autowired
    private ComedyMovieRepository comedyMovieRepository;

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Movie>> getMoviesByYear(@PathVariable int year) {
        List<Movie> movies = movieRepository.findByReleaseYear(year);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/director/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable String director) {
        List<Movie> movies = movieRepository.findByDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam String genre) {
        // System.out.println(genre);
        if (genre.toLowerCase().equals("Action".toLowerCase())) {
            return ResponseEntity.ok().body(this.movieRepository.findByMovieType("action"));
        } else {

            return ResponseEntity.ok().body(this.movieRepository.findByMovieType("comedy"));

        }
        // List<Movie> movies = movieRepository.findAll();
        // return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody MovieDto movie) {
        // if (movie.getGenre().equals("Action")) {

        // } else {

        // }
        Movie newMovie = movieRepository.save(movie.toMovie());
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setReleaseYear(updatedMovie.getReleaseYear());

            Movie updated = movieRepository.save(existingMovie);

            // Return the updated movie with a 200 OK response
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            // If the movie with the given ID is not found, return a 404 Not Found response
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie != null) {
            movieRepository.delete(movie);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found
        }
    }
}
