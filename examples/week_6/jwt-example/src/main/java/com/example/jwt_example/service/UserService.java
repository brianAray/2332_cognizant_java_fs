package com.example.jwt_example.service;

import com.example.jwt_example.repository.EmployeeRepository;
import com.example.jwt_example.repository.UserRepository;
import com.example.jwt_example.repository.entity.User;
import com.example.jwt_example.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private EmployeeService employeeService;

    @Autowired
    public UserService(UserRepository userRepository, EmployeeService employeeService) {
        this.userRepository = userRepository;
        this.employeeService = employeeService;
    }

    public UserDTO mapToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmployee(employeeService.mapToDTO(user.getEmployee()));

        return userDTO;
    }

    public UserDTO getUserByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found by username"));

        return mapToDTO(user);
    }
}

