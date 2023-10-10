package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {

  @Autowired
  MovieService movieService;

  @RequestMapping("/imdbid/{imdbId}")
  public Movie getMovie(@PathVariable String imdbId) {
    return movieService.getMovieByImdbId(imdbId);
  }

  @GetMapping("/movieid/{movieId}")
  public Movie getMovieById(@PathVariable Long movieId) {
    return movieService.getMovieById(movieId);
  }

  @PostMapping("/{imdbId}")
  public Movie addMovie(@PathVariable String imdbId) throws JsonProcessingException {
    return movieService.addMovie(imdbId);
  }
}
