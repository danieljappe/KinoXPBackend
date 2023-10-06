package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dtoMovie.MovieConverter;
import com.example.kinoxpbackend.dtoMovie.MovieDTO;
import com.example.kinoxpbackend.exception.RestExceptionHandler;
import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieConverter movieConverter;

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            movieDTOList.add(movieConverter.toDTO(movies.get(i)));
        }
        return movieDTOList;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(int id, Movie movie) {
        Optional<Movie> movieOpt = movieRepository.findById(id);

        if (movieOpt.isPresent()) {
            Movie movieToUpdate = movieOpt.get();

            movieToUpdate.setMovieName(movie.getMovieName());
            movieToUpdate.setMovieDescription(movie.getMovieDescription());
            movieToUpdate.setGenre(movie.getGenre());
            movieToUpdate.setAgeRestriction(movie.getAgeRestriction());
            movieToUpdate.setRuntime(movie.getRuntime());
            movieToUpdate.setTrailerLink(movie.getTrailerLink());
            movieToUpdate.setPosterLink(movie.getPosterLink());

            return movieRepository.save(movieToUpdate);
        } else {
            throw new Error("Movie with the ID:  " + id + ", does not exist");
        }
    }

    public void deleteMovieById(int id) {
        Optional<Movie> movieOpt = movieRepository.findById(id);
        if (movieOpt.isPresent()){
            movieRepository.deleteById(id);
        } else {
            throw new Error("Movie with the ID:  " + id + ", does not exist");
        }
    }
}