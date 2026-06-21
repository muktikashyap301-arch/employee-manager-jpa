package com.Employee_Manager.jpa_P01.controller;

import com.Employee_Manager.jpa_P01.entity.Employee;
import com.Employee_Manager.jpa_P01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public  Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping()
    public Employee updateEmployee( @PathVariable Integer id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee( @PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully ";
    }

}
