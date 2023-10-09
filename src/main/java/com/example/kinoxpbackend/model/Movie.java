package com.example.kinoxpbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_description")
    private String movieDescription;

    @Column(name = "genre")
    private String genre;

    @Column(name = "age_restriction")
    private int ageRestriction;

    @Column(name = "runtime")
    private int runtime;

    @Column(name = "trailer_link")
    private String trailerLink;

    @Column(name = "poster_link")
    private String posterLink;

    @JsonBackReference
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Showing> showings;


}
