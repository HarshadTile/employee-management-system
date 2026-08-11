package com.harshad.employeemanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

//├── departmentId
//├── departmentName
//├── description
//├── managerName
//├── location
//├── email
//└── createdAt
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotBlank(message = "Department name is required")
    private String departmentName;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Manager Name is required")
    private String managerName;

    @NotBlank(message = "Location is required")
    private String location;

    @Email(message = "Invalid Email Format")
    private String email;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

}
