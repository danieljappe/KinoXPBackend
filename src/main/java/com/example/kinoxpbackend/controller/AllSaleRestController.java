package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.service.AllSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AllSaleRestController {
    @Autowired
    AllSaleService saleService;



}
