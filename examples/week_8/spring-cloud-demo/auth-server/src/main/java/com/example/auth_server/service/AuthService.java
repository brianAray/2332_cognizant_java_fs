package com.example.auth_server.service;

import com.example.auth_server.controller.AuthResponse;
import com.example.auth_server.controller.LoginResponse;
import com.example.auth_server.repository.AuthDAO;
import com.example.auth_server.repository.AuthEntity;
import com.example.auth_server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthDAO authDAO;

    @Autowired
    private JwtUtil jwtUtil;

    public LoginResponse validateLogin(String username, String password){
        AuthEntity authEntity = authDAO.getAuthEntityByUsername(username);
        if(authEntity != null){
            if(authEntity.getPassword().equals(password)){
                String token = jwtUtil.generateToken(username);
                LoginResponse loginResponse = new LoginResponse(authEntity.getUserId(), token);
                return loginResponse;
            }else{
                throw new RuntimeException("Invalid Login Credentials");
            }
        }else{
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

    public AuthResponse validateToken(String token){
        if(jwtUtil.validateToken(token)){
            return new AuthResponse(token, true);
        }else{
            return new AuthResponse(token, false);
        }
    }
}
