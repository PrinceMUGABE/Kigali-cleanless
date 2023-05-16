package com.example.kigalicleaniliness.repository;

import com.example.kigalicleaniliness.model.ClientModel;
import com.example.kigalicleaniliness.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Integer> {
}
