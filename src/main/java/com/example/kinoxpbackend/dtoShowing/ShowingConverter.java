package com.example.kinoxpbackend.dtoShowing;

import com.example.kinoxpbackend.dtoMovie.MovieConverter;
import com.example.kinoxpbackend.dtoTheater.TheaterConverter;
import com.example.kinoxpbackend.dtoTicket.TicketConverter;
import com.example.kinoxpbackend.dtoTicket.TicketDTO;
import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ShowingConverter {

    @Autowired
    TicketConverter ticketConverter;

    public ShowingDTO toDTO(Showing showing){
        return new ShowingDTO(showing.getMovie().getMovieId(),
                showing.getTheater().getTheaterId(), showing.getShowingDateTime()
                );

    }


}
