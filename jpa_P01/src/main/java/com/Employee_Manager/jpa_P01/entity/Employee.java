package com.Employee_Manager.jpa_P01.entity;

import jakarta.persistence.*;

/*
id int primary key auto_increment,
  name varchar(30) not null,
  email varchar(30) not null,
  department varchar(30) not null,
  salary double not null
  */
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 30)
    private String name;

    @Column(nullable = false,length = 30)
    private String email;

    @Column(nullable = false,length = 30)
    private String department;

    @Column(nullable = false)
    private double salary;


    public Employee(){}

    public Employee(Integer id, String name, String email, String department, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
