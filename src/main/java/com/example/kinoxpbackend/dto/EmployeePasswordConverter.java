package com.example.kinoxpbackend.dto;

import com.example.kinoxpbackend.model.Employee;

public class EmployeePasswordConverter {
    public Employee toEntity(EmployeePasswordDTO employeePasswordDTO){
        return new Employee(employeePasswordDTO.employee_id(),
                employeePasswordDTO.employee_password(),
                employeePasswordDTO.is_operator());
    }
}
