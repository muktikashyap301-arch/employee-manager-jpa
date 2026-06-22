package com.JPA.JPA_P02.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 30)
    private String name;

    @Column(nullable = false,length = 30)
    private String location;

    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("department")
    private List<Employee> employee;


    }
