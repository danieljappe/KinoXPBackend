package com.example.kinoxpbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_password")
    private String employeePassword;

    @Column(name = "is_operator")
    private boolean isOperator;

    public Employee(Long employeeId, boolean isOperator){
        this.employeeId = employeeId;
        this.isOperator = isOperator;
    }

    public Employee(Long employee_id,boolean is_operator){
        this.employee_id = employee_id;
        this.is_operator = is_operator;
    }


}
