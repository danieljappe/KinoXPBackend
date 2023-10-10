package com.example.kinoxpbackend.repository;



import com.example.kinoxpbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  Optional<Movie> findByImdbID(String imdbId);

  Optional<Movie> findByMovieId(Long movieId);
}
