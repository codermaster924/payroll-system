package com.example.payroll_system.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payroll_system.Repository.EmployeeRepository;
import com.example.payroll_system.model.Employee;
import com.example.payroll_system.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository repository) {
        this.employeeService = employeeService;
        this.repository = repository;
    }
    @GetMapping
public List<Employee> getAllEmployees() {
    return repository.findAll();
}
@PostMapping
public Employee createEmployee(@RequestBody Employee employee) {
    // 1. Tell the service to calculate the 10% tax
    employeeService.calculateNetSalary(employee); 
    
    // 2. Now save the employee who now has a non-zero netSalary
    return repository.save(employee);
}
    @PostMapping("/{id}/calculate")
public Employee calculate(@PathVariable Long id) {
    Employee employee = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found"));
    
    // This calls your "Accountant" logic to do the 10% tax
    employeeService.calculateNetSalary(employee); 
    
    return employee;
}
    
    @PostMapping("/{id}/approve-leave")
    public Employee approveLeave(@PathVariable Long id) {
        Employee employee = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeService.approveLeaves(employee);

        return employee; 
    }
}
    

