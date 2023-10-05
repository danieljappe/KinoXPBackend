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

    @GetMapping("/showing/{showing_id}")
    public ResponseEntity<Showing> getShowingById(@PathVariable("showing_id") Long showing_id){
        Showing showing = showingService.getShowingById(showing_id);
        return new ResponseEntity<>(showing,HttpStatus.OK);
    }


    @PostMapping("/showing")
    public ResponseEntity<Showing> postShowing(@RequestBody Showing showing) {
        Showing createdShowing = showingService.createShowing(showing);
        return new ResponseEntity<>(createdShowing, HttpStatus.CREATED);
    }


    @PutMapping("/showing/{showing_id}")
    public ResponseEntity<Showing> updateMovie(@PathVariable("showing_id") Long id, @RequestBody Showing showing) {
        Showing updatedShowing = showingService.updateShowing(id, showing);
        return new ResponseEntity<>(updatedShowing, HttpStatus.OK);
    }

    @DeleteMapping("/showing/{showing_id}")
    public ResponseEntity<Showing> deleteMovie(@PathVariable("showing_id") Long id){
        Showing deletedShowing = showingService.deleteShowingById(id);
        return new ResponseEntity<>(deletedShowing, HttpStatus.NO_CONTENT);
    }

}
