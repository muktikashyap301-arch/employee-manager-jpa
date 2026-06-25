package com.JPA.JPA_P02.service;

import com.JPA.JPA_P02.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Integer id , Employee employee);
    String deleteEmployee(Integer id);
}
