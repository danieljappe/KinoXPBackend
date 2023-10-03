package com.example.kinoxpbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<String, Integer>{ //todo: Set type of JpaRepository

}