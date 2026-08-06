package com.harshad.employeemanagementsystem.service;

import com.harshad.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
