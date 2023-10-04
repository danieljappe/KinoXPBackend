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
    private Long employee_id;

    @Column(name = "employee_password")
    private String employee_password;

    @Column(name = "is_operator")
    private boolean is_operator;

    public Employee(Long employee_id,boolean is_operator){
        this.employee_id = employee_id;
        this.is_operator = is_operator;
    }


}
