package com.harshad.employeemanagementsystem.controller;

import com.harshad.employeemanagementsystem.dto.EmployeeRequestDTO;
import com.harshad.employeemanagementsystem.dto.EmployeeResponseDTO;
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
    public EmployeeResponseDTO saveEmployee(
            @RequestBody EmployeeRequestDTO requestDTO) {

        return employeeService.saveEmployee(requestDTO);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO requestDTO) {

        return employeeService.updateEmployee(id, requestDTO);
    }

    @PatchMapping("/{id}")
    public EmployeeResponseDTO updateEmployeePartial(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO requestDTO) {

        return employeeService.updateEmployeePartial(id, requestDTO);
    }
}

