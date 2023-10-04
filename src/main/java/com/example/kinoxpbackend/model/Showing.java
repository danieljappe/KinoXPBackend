package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="showing")
public class Showing {


    @Id
    @Column(name = "showing_id")
    private Long showingId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @Column(name = "showing_date_time")
    private LocalDateTime showingDateTime;


    @OneToMany(mappedBy = "showing", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;


}
