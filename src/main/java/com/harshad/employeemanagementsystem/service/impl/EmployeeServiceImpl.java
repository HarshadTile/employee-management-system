package com.harshad.employeemanagementsystem.service.impl;

import com.harshad.employeemanagementsystem.entity.Employee;
import com.harshad.employeemanagementsystem.repository.EmployeeRepository;
import com.harshad.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }


}
