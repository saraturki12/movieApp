package com.project.movie.repositroy;

import com.project.movie.model.ActionMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionMovieRepository extends JpaRepository<ActionMovie, Long> {

}
