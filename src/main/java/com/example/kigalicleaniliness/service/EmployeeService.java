package com.example.kigalicleaniliness.service;

import com.example.kigalicleaniliness.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel saveEmployee(EmployeeModel employee);
    EmployeeModel findEmployeeById(int code);
    EmployeeModel updateEmployee(EmployeeModel employee);
    List<EmployeeModel> displayEmployees();
    void deleteEmployee(int code);

}
