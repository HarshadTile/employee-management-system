package com.harshad.employeemanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentResponseDTO {

    private Long departmentId;
    private String departmentName;
    private String description;
    private String managerName;
    private String location;
    private String email;
    
}