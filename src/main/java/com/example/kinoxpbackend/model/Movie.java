package com.example.kinoxpbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id")
  private Long movieId;

  @Column(name = "trailer_url")
  private String trailerUrl;

  @Column(name = "age_restriction")
  private String ageRestriction;

  private String title;
  private String year;
  private String rated;
  private String released;
  private String runtime;
  private String genre;
  private String director;
  private String writer;
  private String actors;

  @Column(length = 2000)
  private String plot;
  @Column(length = 2000)
  private String plotDK;
  private String poster;

  private String metascore;
  private String imdbRating;
  private String imdbVotes;

  @Column(unique = true)
  private String imdbID;
  private String website;
  private String response;

  @JsonBackReference
  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<Showing> showings;

}