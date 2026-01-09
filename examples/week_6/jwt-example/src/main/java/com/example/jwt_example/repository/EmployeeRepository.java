package com.example.jwt_example.repository;

import com.example.jwt_example.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findByLocationId(Integer locationId);
}
