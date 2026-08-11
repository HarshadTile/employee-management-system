package com.harshad.employeemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private Long empId;
    private String empName;
    private String email;
    private String phone;
    private BigDecimal salary;
    private LocalDate dateOfJoining;

    private Long departmentId;
    private String departmentName;
}