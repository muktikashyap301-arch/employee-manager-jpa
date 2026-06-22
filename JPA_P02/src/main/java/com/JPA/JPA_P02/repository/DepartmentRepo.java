package com.JPA.JPA_P02.repository;

import com.JPA.JPA_P02.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
