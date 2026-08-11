package com.harshad.employeemanagementsystem.service;

import com.harshad.employeemanagementsystem.dto.DepartmentRequestDTO;
import com.harshad.employeemanagementsystem.dto.DepartmentResponseDTO;
import com.harshad.employeemanagementsystem.entity.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    DepartmentResponseDTO saveDepartment(DepartmentRequestDTO requestDTO);
    List<DepartmentResponseDTO> getAllDepartment();
    DepartmentResponseDTO getDepartmentById(Long id);
    DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO requestDTO);
    DepartmentResponseDTO updateDepartmentPartial(Long id, DepartmentRequestDTO requestDTO);
    ResponseEntity<Void> deleteDepartment(Long id);


}
