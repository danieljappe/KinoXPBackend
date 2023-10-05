package com.example.kinoxpbackend.dtoShowing;

import com.example.kinoxpbackend.dtoMovie.MovieDTO;
import com.example.kinoxpbackend.dtoTheater.TheaterDTO;
import com.example.kinoxpbackend.dtoTicket.TicketDTO;
import com.example.kinoxpbackend.model.Theater;
import com.example.kinoxpbackend.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record ShowingDTO(Long showingId, Long movieId, Long theaterId, LocalDateTime showingDateTime,
                         Set<TicketDTO> ticketDTOSet) {
}
