package com.example.kinoxpbackend.dto.dtoTicket;


import com.example.kinoxpbackend.dto.dtoCustomer.CustomerConverter;
import com.example.kinoxpbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter {

    @Autowired
    CustomerConverter customerConverter;

    public TicketDTO toDTO(Ticket ticket){
        return new TicketDTO(
                ticket.getCustomer().getCustomerPhone(),
                ticket.getShowing().getShowingId(),
                ticket.getSeat().getSeatId(),
                ticket.getTicketId()
        );
    }


}
