package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.dtoShowing.ShowingDTO;
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


    //TODO hent showing fra movieId

    @Autowired
    ShowingService showingService;

    @GetMapping("/showings/months/{months}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ShowingDTO>> getShowings3Months(@PathVariable("months") int months){
        List<ShowingDTO> showingDTOS = showingService.getAllShowingsBetween(months);
        return new ResponseEntity<>(showingDTOS,HttpStatus.OK);
    }



    @GetMapping("/showings")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ShowingDTO>> getAllShowings(){
        List<ShowingDTO> showings = showingService.getAllShowings();
        return new ResponseEntity<>(showings, HttpStatus.OK);
    }

    @GetMapping("/showing/{showing_id}")
    public ResponseEntity<ShowingDTO> getShowingById(@PathVariable("showing_id") Long showing_id){
        ShowingDTO showing = showingService.getShowingById(showing_id);
        return new ResponseEntity<>(showing,HttpStatus.OK);
    }


    @PostMapping(value ="/showing", consumes = "application/json")
    public ResponseEntity<Showing> postShowing(@RequestBody ShowingDTO showingDTO) {
        Showing createdShowing = showingService.createShowing(showingDTO);
        return new ResponseEntity<>(createdShowing, HttpStatus.CREATED);
    }


    @PutMapping("/showing/{showing_id}")
    public ResponseEntity<Showing> updateMovie(@PathVariable("showing_id") Long id, @RequestBody ShowingDTO showingDTO) {
        Showing updatedShowing = showingService.updateShowing(id, showingDTO);
        return new ResponseEntity<>(updatedShowing, HttpStatus.OK);
    }

    @DeleteMapping("/showing/{showing_id}")
    public ResponseEntity<Showing> deleteMovie(@PathVariable("showing_id") Long id){
        Showing deletedShowing = showingService.deleteShowingById(id);
        return new ResponseEntity<>(deletedShowing, HttpStatus.NO_CONTENT);
    }

}
