package com.example.kinoxpbackend.dtoTicket;


import com.example.kinoxpbackend.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TicketConverter {

    public TicketDTO toDTO(Ticket ticket){
        return new TicketDTO(ticket.getTicketId(),ticket.getCustomer(),ticket.getShowing().getShowingId(),
                ticket.getSeat().getSeatId());
    }

    public Set<TicketDTO> toDTOSet(Set<Ticket> tickets) {
        return tickets.stream()
                .map(this::toDTO)
                .collect(Collectors.toSet());
    }
}
