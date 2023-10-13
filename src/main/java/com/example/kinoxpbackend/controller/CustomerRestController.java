package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.dto.dtoCustomer.CustomerDTO;
import com.example.kinoxpbackend.model.Customer;
import com.example.kinoxpbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> postCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.postCustomer(customerDTO), HttpStatus.OK);
    }
}
