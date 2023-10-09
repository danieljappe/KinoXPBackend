package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MovieRestController {

    @Autowired
    MovieService movieService;


    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movie_id") int id){
        Movie selectedMovie = movieService.getMovieById(id);
        return new ResponseEntity<>(selectedMovie, HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping("/movie/{movie_id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("movie_id") int id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/movie/{movie_id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("movie_id") int id){
        movieService.deleteMovieById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}