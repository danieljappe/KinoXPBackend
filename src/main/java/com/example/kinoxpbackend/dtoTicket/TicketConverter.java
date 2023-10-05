package com.example.kinoxpbackend.dtoTicket;


import com.example.kinoxpbackend.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class TicketConverter {

    public TicketDTO toDTO(Ticket ticket){
        return new TicketDTO(ticket.getTicketId(),ticket.getCustomer(),ticket.getShowing().getShowingId(),
                ticket.getSeat().getSeatId());
    }

    public List<TicketDTO> toDTOList(List<Ticket> tickets){
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            ticketDTOList.add(toDTO(tickets.get(i)));
        }
        return ticketDTOList;
    }
}
