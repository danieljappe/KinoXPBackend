package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByShowing(Showing showing);

}
