package com.Employee_Manager.jpa_P01.repository;

import com.Employee_Manager.jpa_P01.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository< Employee, Integer> {
}
