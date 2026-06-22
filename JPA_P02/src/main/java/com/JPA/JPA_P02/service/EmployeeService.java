package com.JPA.JPA_P02.service;

import com.JPA.JPA_P02.entity.Employee;
import com.JPA.JPA_P02.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

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
    public String deleteEmployee(Integer id){
        employeeRepo.deleteById(id);
        return "Employee deleted successfully";
    }

}
