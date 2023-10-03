package com.example.kinoxpbackend.model;

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
@Table(name="movie")
public class Movie {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movie_id;

    @Column(name = "movie_name")
    private String movie_name;

    @Column(name = "movie_description")
    private String movie_description;

    @Column(name = "genre")
    private String genre;

    @Column(name = "age_restriction")
    private int age_restriction;

    @Column(name = "runtime")
    private int runtime;

    @Column(name = "trailer_link")
    private String trailer_link;

    @Column(name = "poster_link")
    private String poster_link;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Showing> showings;


}
