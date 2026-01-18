package com.example.payroll_system.service;

import org.springframework.stereotype.Service;
import com.example.payroll_system.model.Employee;
import com.example.payroll_system.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Value;
@Service
public class EmployeeService {
     private final EmployeeRepository repository;
    @Value("${company.total-working-days}")
     private int totalWorkingDays;
     @Value("${company.paid-leaves}")
     private int paidLeaves;
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    
public void calculateNetSalary(Employee employee) { 
    double salary = employee.getSalary();   
    double net = salary * 0.9; 
    employee.setNetSalary(net);
    repository.save(employee);
}
public void approveLeaves(Employee employee){
    int leaves=employee.getLeaves();
    employee.setLeaves(++leaves);
    if(leaves>paidLeaves){
        double salary=employee.getSalary();
        double daily=salary/totalWorkingDays;
        employee.setPenalty(employee.getPenalty()+daily);
        employee.setNetSalary(employee.getNetSalary()-daily);
    }

    repository.save(employee);
}
}
