package com.example.jwt_example.service;

import com.example.jwt_example.repository.DepartmentRepository;
import com.example.jwt_example.repository.entity.Department;
import com.example.jwt_example.service.DTO.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDTO mapToDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setDepartment(department.getDepartment());
        return departmentDTO;
    }

    public Department getDepartmentById(Integer id){
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
