package com.example.jwt_example.service.DTO;

import java.util.Objects;

public class EmployeeDTO {
    private Integer id;
    private String fullName;
    private DepartmentDTO department;
    private LocationDTO location;

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(department, that.department) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, department, location);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public EmployeeDTO(Integer id, String fullName, DepartmentDTO department, LocationDTO location) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.location = location;
    }

    public EmployeeDTO() {
    }
}
