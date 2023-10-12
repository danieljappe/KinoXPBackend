package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Long> {

    List<Showing> findByShowingDateTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Showing> findByMovie_MovieId(Long movieId);

}
