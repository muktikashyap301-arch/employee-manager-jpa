package com.JPA.JPA_P02.repository;

import com.JPA.JPA_P02.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
