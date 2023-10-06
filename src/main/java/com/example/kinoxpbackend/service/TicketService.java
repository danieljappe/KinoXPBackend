package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dtoTicket.TicketConverter;
import com.example.kinoxpbackend.dtoTicket.TicketDTO;
import com.example.kinoxpbackend.model.Customer;
import com.example.kinoxpbackend.model.Seat;
import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.model.Ticket;
import com.example.kinoxpbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ShowingRepository showingRepository;

    @Autowired
    TicketConverter ticketConverter;

    public List<TicketDTO> getAllTickets(){
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDTO> ticketsDTO = new ArrayList<>();

        for (Ticket ticket : tickets) {
            ticketsDTO.add(ticketConverter.toDTO(ticket));
        }
        return ticketsDTO;
    }

    public List<TicketDTO> getTicketFromShowingId(Long showingId){
        Optional<Showing>optionalShowing = showingRepository.findById(showingId);
        if ((optionalShowing.isPresent())){
            List<Ticket> tickets = ticketRepository.findByShowing(optionalShowing.get());
            List<TicketDTO> ticketsDTO = new ArrayList<>();

            for (Ticket ticket : tickets) {
                ticketsDTO.add(ticketConverter.toDTO(ticket));
            }
            return ticketsDTO;
        }else {
            throw new RuntimeException();
        }


    }


    public Ticket createTicket(TicketDTO ticketDTO) {

        Optional<Customer> customer = customerRepository.findById(ticketDTO.customerPhone());
        Optional<Showing> showing = showingRepository.findById(ticketDTO.showingId());
        Optional<Seat> seat = seatRepository.findById(ticketDTO.seatId());


        Ticket ticket = new Ticket();
        ticket.setCustomer(customer.get());
        ticket.setShowing(showing.get());
        ticket.setSeat(seat.get());


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
