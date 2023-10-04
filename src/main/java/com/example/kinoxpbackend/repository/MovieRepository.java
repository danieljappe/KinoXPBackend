package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{ //todo: Set type of JpaRepository

    List<Movie> findAllByMovieName(String movie_name);

}