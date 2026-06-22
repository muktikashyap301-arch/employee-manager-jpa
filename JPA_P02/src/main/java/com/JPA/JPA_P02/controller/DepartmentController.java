package com.JPA.JPA_P02.controller;

import com.JPA.JPA_P02.entity.Department;
import com.JPA.JPA_P02.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
            public Department getById(@PathVariable Integer id ){
                return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        return departmentService.deleteDepartment(id);
    }
}
