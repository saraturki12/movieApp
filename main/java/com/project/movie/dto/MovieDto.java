package com.project.movie.dto;

import com.project.movie.model.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String title;
    private String genre;
    private String duration;
    private int releasYear;

    public Movie toMovie() {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDuration(Integer.parseInt(duration));
        movie.setReleaseYear(releasYear);
        movie.setMovieType(genre.toLowerCase());
        return movie;
    }

}
