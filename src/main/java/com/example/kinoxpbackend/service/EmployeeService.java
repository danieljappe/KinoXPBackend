package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dto.EmployeeConverter;
import com.example.kinoxpbackend.dto.EmployeeDTO;
import com.example.kinoxpbackend.dto.EmployeePasswordConverter;
import com.example.kinoxpbackend.dto.EmployeePasswordDTO;
import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeePasswordConverter employeePasswordConverter;

    @Autowired
    EmployeeConverter employeeConverter;



    public EmployeeDTO save(EmployeePasswordDTO employeePasswordDTO){
        Employee employee = employeePasswordConverter.toEntity(employeePasswordDTO);
        employeeRepository.save(employee);
        return employeeConverter.toDTO(employee);
    }


}
