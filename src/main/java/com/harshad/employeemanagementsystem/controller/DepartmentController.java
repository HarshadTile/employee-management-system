package com.harshad.employeemanagementsystem.controller;

import com.harshad.employeemanagementsystem.dto.DepartmentRequestDTO;
import com.harshad.employeemanagementsystem.dto.DepartmentResponseDTO;
import com.harshad.employeemanagementsystem.entity.Department;
import com.harshad.employeemanagementsystem.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponseDTO saveDepartment(
            @Valid
            @RequestBody
            DepartmentRequestDTO requestDTO){
        return departmentService.saveDepartment(requestDTO);
  }

    @GetMapping
    public List<DepartmentResponseDTO> getAllDepartments(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public DepartmentResponseDTO getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDTO updateDepartment(@PathVariable Long id,@RequestBody DepartmentRequestDTO requestDTO){
        return departmentService.updateDepartment(id, requestDTO);
    }

    @PatchMapping("/{id}")
    public DepartmentResponseDTO updateDepartmentPartial(
            @PathVariable Long id,
            @RequestBody DepartmentRequestDTO requestDTO){

        return departmentService.updateDepartmentPartial(id, requestDTO);
  }

  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        return departmentService.deleteDepartment(id);
  }
}
