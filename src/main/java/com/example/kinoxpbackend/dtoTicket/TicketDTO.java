package com.example.kinoxpbackend.dtoTicket;

import com.example.kinoxpbackend.dtoCustomer.CustomerDTO;
import com.example.kinoxpbackend.dtoSeat.SeatDTO;
import com.example.kinoxpbackend.dtoShowing.ShowingDTO;
import com.example.kinoxpbackend.model.Customer;
import com.example.kinoxpbackend.model.Seat;

public record TicketDTO(String customerPhone, Long showingId, Long seatId) {
}
