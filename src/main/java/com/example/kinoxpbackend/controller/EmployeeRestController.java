package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.EmployeeDTO;
import com.example.kinoxpbackend.dto.EmployeePasswordDTO;
import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/employee/{employee_id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employee_id")int id){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDTO);
    }


    //Controller for Employee Login - needs id and password
    @GetMapping("/employeeCheck")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO checkEmployee(@RequestBody EmployeePasswordDTO employeePasswordDTO){
        return employeeService.checkEmployee(employeePasswordDTO);
    }

}
