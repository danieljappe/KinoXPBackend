package com.example.kinoxpbackend.dtoMovie;

public record MovieDTO(
        Long movieId,
        String movieName,
        String movieDescription,
        String genre,
        int ageRestriction,
        int runtime,
        String trailerLink,
        String posterLink) {
}
