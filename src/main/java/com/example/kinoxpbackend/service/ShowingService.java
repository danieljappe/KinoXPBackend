package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dto.dtoShowing.ShowingConverter;
import com.example.kinoxpbackend.dto.dtoShowing.ShowingDTO;
import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.repository.MovieRepository;
import com.example.kinoxpbackend.repository.ShowingRepository;
import com.example.kinoxpbackend.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {


    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    ShowingConverter showingConverter;

    public List<ShowingDTO> getAllShowings(){
        List<Showing>showings = showingRepository.findAll();
        List<ShowingDTO>dtoShowings = new ArrayList<>();

        for (Showing showing : showings){
            dtoShowings.add(showingConverter.toDTO(showing));
        }

        return dtoShowings;
    }

    public List<ShowingDTO> getAllShowingsBetween(int months){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = now.plusMonths(months);
        List<Showing>showings = showingRepository.findByShowingDateTimeBetween(now,end);
        List<ShowingDTO>dtoShowings = new ArrayList<>();

        for (Showing showing : showings){
            dtoShowings.add(showingConverter.toDTO(showing));
        }
        return dtoShowings;
    }


    public ShowingDTO getShowingById(Long id){
        Optional<Showing> optionalShowing = showingRepository.findById(id);
        if (optionalShowing.isPresent()){
            return showingConverter.toDTO(optionalShowing.get());
        }else {
            throw new Error("Showing with the ID:  " + id + ", does not exist");
        }
    }


    public List<ShowingDTO> getAllShowingsFromMovieId(Long movieId){
        List<Showing> showings = showingRepository.findByMovie_MovieId(movieId);
        List<ShowingDTO>dtoShowings = new ArrayList<>();

        for (Showing showing : showings){
            dtoShowings.add(showingConverter.toDTO(showing));
        }
        return dtoShowings;
    }



    public Showing createShowing(ShowingDTO showingDTO){

        Movie movie = movieRepository.getReferenceById(showingDTO.movieId());
//                .orElseThrow(() -> new RuntimeException("Movie not found"));
        Theater theater = theaterRepository.findById(showingDTO.theaterId())
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        Showing showing = new Showing();
        showing.setShowingId(0L);
        showing.setMovie(movie);
        showing.setTheater(theater);
        showing.setShowingDateTime(showingDTO.showingDateTime());

        showingRepository.save(showing);
        return showingRepository.save(showing);
    }

    public Showing updateShowing(Long id, ShowingDTO showingDTO){
        Optional<Showing> optionalShowing = showingRepository.findById(id);

        if (optionalShowing.isPresent()){

            Showing showing = optionalShowing.get();

            Movie movie = movieRepository.getReferenceById(showingDTO.movieId());
//                .orElseThrow(() -> new RuntimeException("Movie not found"));
            Theater theater = theaterRepository.findById(showingDTO.theaterId())
                    .orElseThrow(() -> new RuntimeException("Theater not found"));


            showing.setMovie(movie);
            showing.setTheater(theater);
            showing.setShowingDateTime(showingDTO.showingDateTime());

            showingRepository.save(showing);
            return showingRepository.save(showing);
        }else {
            throw new Error("Showing with the ID:  " + id + ", does not exist");
        }

    }
    public Showing deleteShowingById(Long id) {
        Optional<Showing> showingOpt = showingRepository.findById(id);
        if (showingOpt.isPresent()){
            showingRepository.deleteById(id);
            return showingOpt.get();
        } else {
            throw new Error("Showing with the ID:  " + id + ", does not exist");
        }
    }

}
