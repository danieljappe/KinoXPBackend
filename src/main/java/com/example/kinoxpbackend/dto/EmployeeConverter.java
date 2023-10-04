package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee.getEmployee_id(), employee.is_operator());
    }

    public Employee toEmployee(EmployeeDTO employeeDTO){
        return new Employee(employeeDTO.employee_id(), employeeDTO.is_operator());
    }

}
