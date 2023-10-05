package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dtoShowing.ShowingConverter;
import com.example.kinoxpbackend.dtoShowing.ShowingDTO;
import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {


    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    ShowingConverter showingConverter;

    public List<Showing> getAllShowings(){
        return showingRepository.findAll();
    }

    public ShowingDTO getShowingById(Long id){
        Optional<Showing> optionalShowing = showingRepository.findById(id);
        if (optionalShowing.isPresent()){
            return showingConverter.toDTO(optionalShowing.get());
        }else {
            throw new Error("Showing with the ID:  " + id + ", does not exist");
        }
    }

    public Showing createShowing(Showing showing){
        return showingRepository.save(showing);
    }

    public Showing updateShowing(Long id, Showing showing){
        Optional<Showing> optionalShowing = showingRepository.findById(id);

        if (optionalShowing.isPresent()){
            Showing showingToUpdate = optionalShowing.get();
            showingToUpdate.setMovie(showing.getMovie());
            showingToUpdate.setShowingDateTime(showing.getShowingDateTime());
            showingToUpdate.setTheater(showing.getTheater());
//            showingToUpdate.setTickets(showing.getTickets()); I do not think line is necessary but idk
            return showingRepository.save(showingToUpdate);
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
