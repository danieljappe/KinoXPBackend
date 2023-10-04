package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.stereotype.Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  public List<Movie> getAllMovies(){
    List<Movie> movies = movieRepository.findAll();
    return movies;
  }

  public Movie createMovie(Movie movie){
    Movie movieToSave = new Movie();
    /*movieToSave.setMovie_name("");
    movieToSave.setMovie_description("");
    movieToSave.setGenre("");
    movieToSave.setAge_restriction(0);
    movieToSave.setRuntime(0);
    movieToSave.setTrailer_link("");
    movieToSave.setPoster_link("");*/
    return movieRepository.save(movieToSave);
  }


}