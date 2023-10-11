package com.example.kinoxpbackend.dto.dtoShowing;


import java.time.LocalDateTime;


public record ShowingDTO(Long movieId, Long theaterId, LocalDateTime showingDateTime, Long showingId) {
}
