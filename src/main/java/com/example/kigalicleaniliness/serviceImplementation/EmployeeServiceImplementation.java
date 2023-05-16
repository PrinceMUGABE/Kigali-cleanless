package com.example.kigalicleaniliness.serviceImplementation;

import com.example.kigalicleaniliness.model.ClientModel;
import com.example.kigalicleaniliness.model.EmployeeModel;
import com.example.kigalicleaniliness.repository.EmployeeRepository;
import com.example.kigalicleaniliness.service.ClientService;
import com.example.kigalicleaniliness.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    EmployeeRepository repo;

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        return repo.save(employee);
    }

    @Override
    public EmployeeModel findEmployeeById(int code) {
        return repo.findById(code).orElse(null);
    }

    @Override
    public EmployeeModel updateEmployee(EmployeeModel employee) {
        EmployeeModel savedEmployee = repo.findById(employee.getId()).orElse(null);
        if (savedEmployee!=null){
            EmployeeModel updateEmployee = new EmployeeModel();
            updateEmployee.setFirstname(employee.getFirstname());
            updateEmployee.setLastname(employee.getLastname());
            updateEmployee.setRole(employee.getRole());
            updateEmployee.setPhone(employee.getPhone());
            updateEmployee.setSalary(employee.getSalary());

            return repo.save(updateEmployee);
        }
        else {
            return repo.save(employee);
        }
    }

    @Override
    public List<EmployeeModel> displayEmployees() {
        return repo.findAll();
    }

    @Override
    public void deleteEmployee(int code) {
        EmployeeModel savedEmployee = repo.findById(code).orElse(null);
        if (savedEmployee!=null){
            repo.delete(savedEmployee);
        }
    }
}
