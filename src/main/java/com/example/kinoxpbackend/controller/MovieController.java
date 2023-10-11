package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.dtoMovie.MovieRequest;
import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
@CrossOrigin
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/getAll")
    public Movie[] getAllMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping("/imdb-id/{imdbId}")
    public Movie getMovie(@PathVariable String imdbId) {
        return movieService.getMovieByImdbId(imdbId);
    }

    @RequestMapping("/movie-id/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/{imdbId}")
    public Movie addMovie(@RequestBody MovieRequest request) throws JsonProcessingException {
        return movieService.addMovie(request.getImdbId(), request.getTrailerUrl(), request.getAgeRestriction());
    }

    @DeleteMapping("/{imdbID}")
    public Movie deleteMovie(@PathVariable String imdbID){
        return movieService.deleteMovie(imdbID);
    }

}
