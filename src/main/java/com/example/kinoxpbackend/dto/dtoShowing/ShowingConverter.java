package com.example.kinoxpbackend.dto.dtoShowing;

import com.example.kinoxpbackend.dto.dtoTicket.TicketConverter;
import com.example.kinoxpbackend.model.Showing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowingConverter {

    @Autowired
    TicketConverter ticketConverter;

    public ShowingDTO toDTO(Showing showing){
        return new ShowingDTO(showing.getMovie().getMovieId(), showing.getTheater().getTheaterId(), showing.getShowingDateTime());
    }

}
