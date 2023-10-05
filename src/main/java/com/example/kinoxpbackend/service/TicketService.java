package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.repository.TheaterRepository;
import com.example.kinoxpbackend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;


}
