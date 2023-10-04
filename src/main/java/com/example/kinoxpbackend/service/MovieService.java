package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class MovieService {
  @Autowired
  MovieRepository movieRepository;



  public List<Movie> getAllMovies(){
    List<Movie> movies = movieRepository.findAll();
    return movies;
  }


}