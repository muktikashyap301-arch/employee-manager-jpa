package com.JPA.JPA_P02.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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
    private String name;

    @Column(nullable = false,length = 30)
    private String email;

    @Column(nullable = false)
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties("employee")
    private Department department;

}