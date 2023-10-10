package com.example.kinoxpbackend.dto.dtoEmployee;

import com.example.kinoxpbackend.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeePasswordConverter {

    public Employee toEntity(EmployeePasswordDTO employeePasswordDTO){
        return new Employee(employeePasswordDTO.employee_id(),
                employeePasswordDTO.employee_password(),
                employeePasswordDTO.is_operator(), employeePasswordDTO.employee_name());
    }
}
