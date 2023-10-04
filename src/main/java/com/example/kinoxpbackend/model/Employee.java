package com.example.kinoxpbackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "employee_id")
    private Long employee_id;

    @Column(name = "employee_password")
    private String employee_password;

    @Column(name = "is_operator")
    private boolean is_operator;


}
