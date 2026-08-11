package com.harshad.employeemanagementsystem.service.impl;

import com.harshad.employeemanagementsystem.dto.DepartmentRequestDTO;
import com.harshad.employeemanagementsystem.dto.DepartmentResponseDTO;
import com.harshad.employeemanagementsystem.entity.Department;
import com.harshad.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.harshad.employeemanagementsystem.repository.DepartmentRepository;
import com.harshad.employeemanagementsystem.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }


    @Override
    public DepartmentResponseDTO saveDepartment(DepartmentRequestDTO requestDTO) {
        Department dept = new Department();

        dept.setDepartmentName(requestDTO.getDepartmentName());
        dept.setDescription(requestDTO.getDescription());
        dept.setManagerName(requestDTO.getManagerName());
        dept.setLocation(requestDTO.getLocation());
        dept.setEmail(requestDTO.getEmail());

        Department savedDepartment =  departmentRepository.save(dept);
        return mapToResponseDTO(savedDepartment);
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartment() {
        return departmentRepository
                .findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();

    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {

        Department dept = departmentRepository
                .findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
        return mapToResponseDTO(dept);
    }

    @Override
    public DepartmentResponseDTO updateDepartment(Long id, DepartmentRequestDTO requestDTO) {
        Department dept = departmentRepository
                .findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(id));

        dept.setDepartmentName(requestDTO.getDepartmentName());
        dept.setDescription(requestDTO.getDescription());
        dept.setManagerName(requestDTO.getManagerName());
        dept.setLocation(requestDTO.getLocation());
        dept.setEmail(requestDTO.getEmail());

        Department savedDepartment = departmentRepository.save(dept);
        return mapToResponseDTO(savedDepartment);

    }

    @Override
    public DepartmentResponseDTO updateDepartmentPartial(Long id, DepartmentRequestDTO requestDTO) {
        Department dept = departmentRepository
                .findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException(id));


        if(requestDTO.getDepartmentName() != null){
            dept.setDepartmentName(requestDTO.getDepartmentName());
        }
        if(requestDTO.getDescription() != null){
            dept.setDescription(requestDTO.getDescription());
        }
        if(requestDTO.getManagerName()!= null){
            dept.setManagerName(requestDTO.getManagerName());
        }

        if(requestDTO.getLocation() != null){
            dept.setLocation(requestDTO.getLocation());
        }
        if(requestDTO.getEmail() != null){
            dept.setEmail(requestDTO.getEmail());
        }

        Department savedDepartment = departmentRepository.save(dept);
        return mapToResponseDTO(savedDepartment);

    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Long id) {
        Department dept = departmentRepository
                .findById(id)
                .orElseThrow(()->
                        new DepartmentNotFoundException(id));

        departmentRepository.delete(dept);
        return ResponseEntity.noContent().build();
    }

    private DepartmentResponseDTO mapToResponseDTO(Department department) {

        DepartmentResponseDTO responseDTO = new DepartmentResponseDTO();

        responseDTO.setDepartmentId(department.getDepartmentId());
        responseDTO.setDepartmentName(department.getDepartmentName());
        responseDTO.setDescription(department.getDescription());
        responseDTO.setManagerName(department.getManagerName());
        responseDTO.setLocation(department.getLocation());
        responseDTO.setEmail(department.getEmail());

        return responseDTO;
    }
}
