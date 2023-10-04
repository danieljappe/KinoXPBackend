package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class MovieRestController {

  @Autowired
  MovieService movieService;


  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getAllMovies(){
    List<Movie> movies = movieService.getAllMovies();
    return new ResponseEntity<>(movies,HttpStatus.OK);
  }


}