package com.project.movie.repositroy;

import com.project.movie.model.ComedyMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComedyMovieRepository extends JpaRepository<ComedyMovie, Long> {
}
