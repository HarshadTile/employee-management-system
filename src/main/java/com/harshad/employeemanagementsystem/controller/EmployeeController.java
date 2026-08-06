package com.harshad.employeemanagementsystem.controller;

import com.harshad.employeemanagementsystem.entity.Employee;
import com.harshad.employeemanagementsystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

}
