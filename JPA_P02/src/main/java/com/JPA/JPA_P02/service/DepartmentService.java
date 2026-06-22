package com.JPA.JPA_P02.service;

import com.JPA.JPA_P02.entity.Department;
import com.JPA.JPA_P02.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(Integer id){
        return departmentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Department not found by id= "+ id));
    }

    public String deleteDepartment(Integer id){
        departmentRepo.deleteById(id);
        return "Department deleted successfully";
    }

}
