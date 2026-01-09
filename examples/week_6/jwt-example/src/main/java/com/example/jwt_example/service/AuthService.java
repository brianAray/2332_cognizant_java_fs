package com.example.jwt_example.service;

import com.example.jwt_example.controller.response.LoginResponse;
import com.example.jwt_example.service.DTO.UserDTO;
import com.example.jwt_example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserService userService;

    private JwtUtil jwtUtil;

    @Autowired
    public AuthService(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse validateLogin(String username, String password){
        UserDTO userDTO = userService.getUserByUsername(username);

        if(userDTO.getPassword().equals(password)){
            String token = jwtUtil.generateToken(username);
            LoginResponse loginResponse = new LoginResponse();

            loginResponse.setUserId(userDTO.getId());
            loginResponse.setUsername(userDTO.getUsername());
            loginResponse.setEmployeeId(userDTO.getEmployee().getId());
            loginResponse.setToken(token);

            return loginResponse;
        }else{
            throw new RuntimeException("Invalid Login");
        }
    }
}
