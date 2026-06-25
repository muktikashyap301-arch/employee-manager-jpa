package com.JPA.JPA_P02.service;

import com.JPA.JPA_P02.entity.Employee;
import com.JPA.JPA_P02.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    public EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(Integer id){
        return employeeRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found by id="+ id));
    }
    public Employee updateEmployee(Integer id , Employee employee){
        Employee existingEmployee=employeeRepo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found by id="+ id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }
    public String deleteEmployee(Integer id){
        employeeRepo.deleteById(id);
        return "Employee deleted successfully";
    }

}
