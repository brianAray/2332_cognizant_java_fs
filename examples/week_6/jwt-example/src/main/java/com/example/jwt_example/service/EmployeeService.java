package com.example.jwt_example.service;

import com.example.jwt_example.repository.EmployeeRepository;
import com.example.jwt_example.repository.entity.Employee;
import com.example.jwt_example.service.DTO.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentService departmentService;
    private LocationService locationService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentService departmentService, LocationService locationService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
        this.locationService = locationService;
    }

    public EmployeeDTO mapToDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setLocation(locationService.mapToDTO(employee.getLocation()));
        employeeDTO.setDepartment(departmentService.mapToDTO(employee.getDepartment()));

        return employeeDTO;
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
