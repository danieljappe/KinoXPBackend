package com.example.kinoxpbackend.dto.dtoShowing;


import java.time.LocalDateTime;


public record ShowingDTO(Long movieOmdbResponse, Long theaterId, LocalDateTime showingDateTime) {
}
