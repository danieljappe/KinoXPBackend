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
@Table(name="seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;


    //row-seatnum
    @Column(name = "seat_number")
    private String seatNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

}
