package com.example.kinoxpbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {   //todo: custom exceptions


  //NOT FOUND ERROR
  @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleStudentNotFoundException(RuntimeException ex){
    Map<String, Object> responseBody = new HashMap<>();
    responseBody.put("timestamp", LocalDateTime.now());
    responseBody.put("message", ex.getMessage());
    return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
  }


  //INTERNAL SERVER ERROR
  @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Object> handleGeneralException(Exception ex){
    Map<String, Object> responseBody = new HashMap<>();
    responseBody.put("timestamp", LocalDateTime.now());
    responseBody.put("message", "An error has occured: " + ex.getMessage());
    return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
  }


}
