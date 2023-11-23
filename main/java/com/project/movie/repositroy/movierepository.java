package com.project.movie.repositroy;

import com.project.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movierepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);

    List<Movie> findByReleaseYear(int year);

    List<Movie> findByDirector(String director);

    List<Movie> findByMovieType(String type);

    // Custom Query Methods with @Query Annotation
    @Query("SELECT m FROM Movie m WHERE m.releaseYear > :year")
    List<Movie> findReleasedAfterYear(@Param("year") int year);
}
