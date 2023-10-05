package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.model.Ticket;
import com.example.kinoxpbackend.repository.TheaterRepository;
import com.example.kinoxpbackend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }
//    public Ticket getTicketById(){
//
//    }

    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticket){
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);

        if (optionalTicket.isPresent()){
            Ticket ticketToUpdate = optionalTicket.get();
            ticketToUpdate.setCustomer(ticket.getCustomer());
            ticketToUpdate.setShowing(ticket.getShowing());
            ticketToUpdate.setSeat(ticket.getSeat());

            return ticketRepository.save(ticketToUpdate);

        }else {
            throw new Error("Ticket with the ID:  " + id + ", does not exist");

        }

    }

    public Ticket deleteTicket(Long id){
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()){
            ticketRepository.deleteById(id);
            return ticketOptional.get();
        } else {
            throw new Error("Showing with the ID:  " + id + ", does not exist");
        }
    }

}
