package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.model.Ticket;
import com.example.kinoxpbackend.service.ShowingService;
import com.example.kinoxpbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TicketRestController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/tickets")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Ticket>> getAllTickets(){
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }


    @PostMapping("/ticket")
    public ResponseEntity<Ticket> postTicket(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }


    @PutMapping("/ticket/{ticket_id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable("ticket_id") Long id, @RequestBody Ticket ticket) {
        Ticket updatedTicket = ticketService.updateTicket(id, ticket);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    @DeleteMapping("/ticket/{ticket_id}")
    public ResponseEntity<Ticket> deleteMovie(@PathVariable("ticket_id") Long id){
        Ticket deletedTicket = ticketService.deleteTicket(id);
        return new ResponseEntity<>(deletedTicket, HttpStatus.NO_CONTENT);
    }
}
