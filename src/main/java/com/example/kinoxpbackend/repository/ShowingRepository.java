package com.example.kinoxpbackend.repository;

import com.example.kinoxpbackend.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Long> {
}
