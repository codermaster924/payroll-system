package com.example.payroll_system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payroll_system.model.Employee;
@Repository
public interface  EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
