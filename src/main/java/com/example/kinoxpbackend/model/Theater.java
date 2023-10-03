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
@Table(name="theater")
public class Theater {

    @Id
    @Column(name = "theater_id")
    private Long theater_id;

    @Column(name = "theater_number")
    private int theater_number;

    @Column(name = "total_seats")
    private int total_seats;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Showing> showings;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Seat> seats;

}
