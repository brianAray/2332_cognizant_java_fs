package com.example.jwt_example.service.DTO;

import java.util.Objects;

public class DepartmentDTO {
    private Integer id;
    private String department;

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDTO that = (DepartmentDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public DepartmentDTO(Integer id, String department) {
        this.id = id;
        this.department = department;
    }

    public DepartmentDTO() {
    }
}
