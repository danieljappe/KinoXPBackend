package com.example.kinoxpbackend.dtoMovie;


import com.example.kinoxpbackend.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {


//    public Movie toEntity(MovieDTO movieDTO){
//        return new Movie(movieDTO.movieId(),movieDTO.movieName(),movieDTO.movieDescription(),movieDTO.genre(),
//                movieDTO.ageRestriction(), movieDTO.runtime(), movieDTO.trailerLink(), movieDTO.posterLink());
//    }

    public MovieDTO toDTO(Movie movie){
        return new MovieDTO(movie.getMovieId(),movie.getMovieName(),movie.getMovieDescription(),movie.getGenre(),
                movie.getAgeRestriction(), movie.getRuntime(), movie.getTrailerLink(), movie.getPosterLink());
    }

}
