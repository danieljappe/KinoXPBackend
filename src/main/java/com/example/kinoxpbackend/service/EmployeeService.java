package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dto.dtoEmployee.EmployeeConverter;
import com.example.kinoxpbackend.dto.dtoEmployee.EmployeeDTO;
import com.example.kinoxpbackend.dto.dtoEmployee.EmployeePasswordConverter;
import com.example.kinoxpbackend.dto.dtoEmployee.EmployeePasswordDTO;
import com.example.kinoxpbackend.model.Employee;
import com.example.kinoxpbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeePasswordConverter employeePasswordConverter;

    @Autowired
    EmployeeConverter employeeConverter;



    //Method that checks id and password match with an employee in the DB - FOR LOGIN
    public EmployeeDTO checkEmployee(EmployeePasswordDTO employeePasswordDTO){
        Employee employee = employeePasswordConverter.toEntity(employeePasswordDTO);
        Optional<Employee> optEmployee = Optional.ofNullable(employeeRepository.findByEmployeeId(employee.getEmployeeId()));
        if (optEmployee.isPresent()&& Objects.equals(optEmployee.get().getEmployeePassword(), employee.getEmployeePassword())){
            return employeeConverter.toDTO(optEmployee.get());
        }else {
            throw  new RuntimeException("wrong credentials");
        }
    }

    public EmployeeDTO save(EmployeePasswordDTO employeePasswordDTO){
        Employee employee = employeePasswordConverter.toEntity(employeePasswordDTO);
        employeeRepository.save(employee);
        return employeeConverter.toDTO(employee);
    }

    public EmployeeDTO getEmployeeById(int id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return employeeConverter.toDTO(optionalEmployee.get());
        }else {
            throw new RuntimeException("employee not found");
        }
    }


}
