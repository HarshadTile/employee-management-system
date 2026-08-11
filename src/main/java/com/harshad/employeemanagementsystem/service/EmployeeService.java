package com.harshad.employeemanagementsystem.service;

import com.harshad.employeemanagementsystem.dto.EmployeeRequestDTO;
import com.harshad.employeemanagementsystem.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO saveEmployee(EmployeeRequestDTO requestDTO);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO);

    EmployeeResponseDTO updateEmployeePartial(Long id, EmployeeRequestDTO requestDTO);
}