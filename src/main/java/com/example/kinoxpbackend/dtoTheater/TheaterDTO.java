package com.example.kinoxpbackend.dtoTheater;

import com.example.kinoxpbackend.dtoSeat.SeatDTO;

import java.util.Set;

public record TheaterDTO(Long theaterId, int theaterNumber, int totalSeats) {
}
