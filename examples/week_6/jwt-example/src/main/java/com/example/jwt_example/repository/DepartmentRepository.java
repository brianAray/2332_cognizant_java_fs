package com.example.jwt_example.repository;

import com.example.jwt_example.repository.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findByDepartment(String department);
    boolean existsByDepartment(String department);
}
