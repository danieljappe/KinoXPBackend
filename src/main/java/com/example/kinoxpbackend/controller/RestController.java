package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  Service service;

}