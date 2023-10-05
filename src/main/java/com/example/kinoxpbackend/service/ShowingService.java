package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.repository.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {


    @Autowired
    ShowingRepository showingRepository;

    public List<Showing> getAllShowings(){
        return showingRepository.findAll();
    }

    public Showing createShowing(Showing showing){
        return showingRepository.save(showing);
    }



}
