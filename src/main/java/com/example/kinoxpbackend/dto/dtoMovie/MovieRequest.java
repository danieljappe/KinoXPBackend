package com.example.kinoxpbackend.dto.dtoMovie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequest {
    private String imdbId;
    private String trailerUrl;
    private String ageRestriction;

}
