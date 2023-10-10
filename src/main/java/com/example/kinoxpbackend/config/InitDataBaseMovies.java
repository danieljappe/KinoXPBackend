package com.example.kinoxpbackend.config;


import com.example.kinoxpbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDataBaseMovies implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    public void run(ApplicationArguments args) throws Exception {
        movieService.addMovie("tt0241527", "https://www.youtube.com/watch?v=VyHV0BRtdxo&ab_channel=RottenTomatoesClassicTrailers", "age  restrection is 15");
        movieService.addMovie("tt1877830", "https://www.youtube.com/watch?v=-FZ-pPFAjYY&ab_channel=FilmSelectTrailer", "age restrection is 15");
        movieService.addMovie("tt7631058", "https://www.youtube.com/watch?v=V75dMMIW2B4&ab_channel=Movieclips", "age restriction is 18");
        movieService.addMovie("tt2265171", "https://www.youtube.com/watch?v=m6Q7KnXpNOg&ab_channel=SonyPicturesClassics", "age restriction is 21");
    }
}
