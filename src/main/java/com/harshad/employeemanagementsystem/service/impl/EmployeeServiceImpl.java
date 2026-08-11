package com.harshad.employeemanagementsystem.service.impl;

import com.harshad.employeemanagementsystem.dto.EmployeeRequestDTO;
import com.harshad.employeemanagementsystem.dto.EmployeeResponseDTO;
import com.harshad.employeemanagementsystem.entity.Department;
import com.harshad.employeemanagementsystem.entity.Employee;
import com.harshad.employeemanagementsystem.exception.DepartmentNotFoundException;
import com.harshad.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.harshad.employeemanagementsystem.repository.DepartmentRepository;
import com.harshad.employeemanagementsystem.repository.EmployeeRepository;
import com.harshad.employeemanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            DepartmentRepository departmentRepository) {

        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO requestDTO) {
        Department department = departmentRepository
                .findById(requestDTO.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                requestDTO.getDepartmentId()));

        Employee employee = new Employee();

        employee.setEmpName(requestDTO.getEmpName());
        employee.setEmail(requestDTO.getEmail());
        employee.setPhone(requestDTO.getPhone());
        employee.setSalary(requestDTO.getSalary());
        employee.setDateOfJoining(requestDTO.getDateOfJoining());

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository
                .findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        return mapToResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO requestDTO) {

        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        Department department = departmentRepository
                .findById(requestDTO.getDepartmentId())
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                requestDTO.getDepartmentId()));

        employee.setEmpName(requestDTO.getEmpName());
        employee.setEmail(requestDTO.getEmail());
        employee.setPhone(requestDTO.getPhone());
        employee.setSalary(requestDTO.getSalary());
        employee.setDateOfJoining(requestDTO.getDateOfJoining());
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToResponseDTO(savedEmployee);
    }

    @Override
    public EmployeeResponseDTO updateEmployeePartial(
            Long id,
            EmployeeRequestDTO requestDTO) {

        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));

        if (requestDTO.getEmpName() != null) {
            employee.setEmpName(requestDTO.getEmpName());
        }

        if (requestDTO.getEmail() != null) {
            employee.setEmail(requestDTO.getEmail());
        }

        if (requestDTO.getPhone() != null) {
            employee.setPhone(requestDTO.getPhone());
        }

        if (requestDTO.getSalary() != null) {
            employee.setSalary(requestDTO.getSalary());
        }

        if (requestDTO.getDateOfJoining() != null) {
            employee.setDateOfJoining(requestDTO.getDateOfJoining());
        }

        if (requestDTO.getDepartmentId() != null) {

            Department department = departmentRepository
                    .findById(requestDTO.getDepartmentId())
                    .orElseThrow(() ->
                            new DepartmentNotFoundException(
                                    requestDTO.getDepartmentId()));

            employee.setDepartment(department);
        }

        Employee savedEmployee = employeeRepository.save(employee);

        return mapToResponseDTO(savedEmployee);
    }



    private EmployeeResponseDTO mapToResponseDTO(Employee employee) {

        EmployeeResponseDTO responseDTO =
                new EmployeeResponseDTO();

        responseDTO.setEmpId(employee.getEmpId());
        responseDTO.setEmpName(employee.getEmpName());
        responseDTO.setEmail(employee.getEmail());
        responseDTO.setPhone(employee.getPhone());
        responseDTO.setSalary(employee.getSalary());
        responseDTO.setDateOfJoining(employee.getDateOfJoining());

        if (employee.getDepartment() != null) {
            responseDTO.setDepartmentId(
                    employee.getDepartment().getDepartmentId());

            responseDTO.setDepartmentName(
                    employee.getDepartment().getDepartmentName());
        }

        return responseDTO;
    }


}