package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
  private final Repository repository;

  @Autowired
  public Service(Repository repository){
    this.repository = repository;
  }

}