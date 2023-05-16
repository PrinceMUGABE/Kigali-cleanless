package com.example.kigalicleaniliness.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Employee_table")
@Data
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String role;
    private float salary;


}
