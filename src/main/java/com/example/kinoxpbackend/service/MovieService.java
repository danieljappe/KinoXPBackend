package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.facade.OmdbFacade;
import com.example.kinoxpbackend.dto.dtoMovie.MovieOmdbResponse;
import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.List;

@Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  @Autowired
  OmdbFacade omdbFacade;

  public Movie getMovieByImdbId(String imdbId) {
    return movieRepository.findByImdbID(imdbId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
  }

  public Movie getMovieById(Long movieId) {
    return movieRepository.findByMovieId(movieId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
  }

  public Movie addMovie(String imdbId, String trailerUrl, String ageRestriction) throws JsonProcessingException {
    MovieOmdbResponse dto = omdbFacade.getMovie(imdbId);

    Movie movie = Movie.builder()
            .title(dto.getTitle())
            .year(dto.getYear())
            .rated(dto.getRated())
            .released(dto.getReleased())
            .runtime(dto.getRuntime())
            .genre(dto.getGenre())
            .director(dto.getDirector())
            .writer(dto.getWriter())
            .actors(dto.getActors())
            .metascore(dto.getMetascore())
            .imdbRating(dto.getImdbRating())
            .imdbVotes(dto.getImdbVotes())
            .website(dto.getWebsite())
            .response(dto.getResponse())
            .plot(dto.getPlot())
            //.plotDK(dkPlot)
            .poster(dto.getPoster())
            .imdbID(dto.getImdbID())
            .trailerUrl(trailerUrl)
            .ageRestriction(ageRestriction)
            .build();


    try {
      movieRepository.save(movie);
      return movie;
    } catch (DataIntegrityViolationException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getRootCause().getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not add movie");
    }
  }

  public Movie deleteMovie(String imdbID){
      Movie movie = movieRepository.findByImdbID(imdbID).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
      movieRepository.delete(movie);
      return movie;
  }

  public Movie[] getAllMovies() {
    return movieRepository.findAll().toArray(new Movie[0]);
  }
}
