package com.project.movie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "movie_type")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int releaseYear;
    private int duration;

    private String director;
    private String movieType;

    public Long getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    // public Movie() {
    // }

    public Movie(Long id, String title, int releaseYear, int duration, String director) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.director = director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}