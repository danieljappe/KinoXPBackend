package com.example.kinoxpbackend.dtoTheater;

import com.example.kinoxpbackend.model.Theater;
import org.springframework.stereotype.Component;

@Component
public class TheaterConverter {

    public TheaterDTO toDTO(Theater theater){
        return new TheaterDTO(theater.getTheaterId(), theater.getTheaterNumber(), theater.getTotalSeats());


    }


}
