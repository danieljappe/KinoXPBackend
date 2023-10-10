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
       movieService.addMovie("tt0241527");
       movieService.addMovie("tt1877830");
       movieService.addMovie("tt7631058");
       movieService.addMovie("tt2265171");
    }
}
