package com.example.kinoxpbackend.dto.dtoEmployee;

import com.example.kinoxpbackend.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee.getEmployeeId(), employee.isOperator(), employee.getEmployeeName());
    }
    public Employee toEmployee(EmployeeDTO employeeDTO){
        return new Employee(employeeDTO.employee_id(), employeeDTO.is_operator(), employeeDTO.employee_name());
    }

}
