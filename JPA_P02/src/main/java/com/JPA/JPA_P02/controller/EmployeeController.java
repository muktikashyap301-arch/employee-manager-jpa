package com.JPA.JPA_P02.controller;

import com.JPA.JPA_P02.entity.Department;
import com.JPA.JPA_P02.entity.Employee;
import com.JPA.JPA_P02.service.EmployeeService;
import com.JPA.JPA_P02.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody Employee employee ){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id ){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updatingEmployee(@PathVariable Integer id ,@Valid @RequestBody Employee employee ){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }
}
