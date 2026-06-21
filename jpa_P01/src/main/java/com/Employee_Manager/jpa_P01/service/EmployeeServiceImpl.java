package com.Employee_Manager.jpa_P01.service;

import com.Employee_Manager.jpa_P01.entity.Employee;
import com.Employee_Manager.jpa_P01.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee) ;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found by "+ id ));
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found by "+ id ));
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepo.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found by "+ id ));
        employeeRepo.delete(existingEmployee);
    }
}
