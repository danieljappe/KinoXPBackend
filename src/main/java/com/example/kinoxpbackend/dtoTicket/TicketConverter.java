package com.example.kinoxpbackend.dtoTicket;


import com.example.kinoxpbackend.dtoCustomer.CustomerConverter;
import com.example.kinoxpbackend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TicketConverter {

    @Autowired
    CustomerConverter customerConverter;

    public TicketDTO toDTO(Ticket ticket){
        return new TicketDTO(
                ticket.getCustomer().getCustomerPhone(),
                ticket.getShowing().getShowingId(),
                ticket.getSeat().getSeatId()
        );
    }


}
