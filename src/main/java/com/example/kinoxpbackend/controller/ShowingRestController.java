package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.model.Movie;
import com.example.kinoxpbackend.model.Showing;
import com.example.kinoxpbackend.service.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ShowingRestController {


    @Autowired
    ShowingService showingService;

    @GetMapping("/showings")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Showing>> getAllShowings(){
        List<Showing> showings = showingService.getAllShowings();
        return new ResponseEntity<>(showings, HttpStatus.OK);
    }


    @PostMapping("/showing")
    public ResponseEntity<Showing> postSho(@RequestBody Showing showing) {
        Showing createdShowing = showingService.createShowing(showing);
        return new ResponseEntity<>(createdShowing, HttpStatus.CREATED);
    }


}
