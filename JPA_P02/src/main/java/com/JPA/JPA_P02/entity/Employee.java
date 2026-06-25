package com.JPA.JPA_P02.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 30)
    @NotBlank(message = "Name cannot be empty ... ")
    private String name;

    @Column(nullable = false,length = 30)
    @NotBlank(message = "Email cannot be empty ...")
    @Email(message = "Invalid Email format ...")
    private String email;

    @Column(nullable = false)
    @Min(value = 1,message = "Salary must be greater than zero ... ")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("employee")
    private Department department;

}