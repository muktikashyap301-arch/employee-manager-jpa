package com.JPA.JPA_P02.service;

import com.JPA.JPA_P02.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Integer id);
    Department updateDepartment(Integer id,Department department);
    String deleteDepartment(Integer id);
}
