package com.example.jwt_example.service.DTO;

import java.util.Objects;

public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private EmployeeDTO employee;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employee=" + employee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password) && Objects.equals(employee, userDTO.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, employee);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public UserDTO(Integer id, String username, String password, EmployeeDTO employee) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    public UserDTO() {
    }
}
