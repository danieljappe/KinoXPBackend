package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.EmployeeDTO;
import com.example.kinoxpbackend.dto.EmployeePasswordDTO;
import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmployeeRestController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO postEmployee(@RequestBody EmployeePasswordDTO employeePasswordDTO){
        return employeeService.save(employeePasswordDTO);
    }

}
