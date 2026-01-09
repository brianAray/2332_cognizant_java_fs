package com.example.jwt_example.controller;

import com.example.jwt_example.controller.request.LoginRequest;
import com.example.jwt_example.controller.response.LoginResponse;
import com.example.jwt_example.repository.entity.User;
import com.example.jwt_example.service.DTO.UserDTO;
import com.example.jwt_example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


}
