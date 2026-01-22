package com.example.auth_server.controller;

import com.example.auth_server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<?> validateLogin(@RequestBody LoginRequest loginRequest){
        try{
            LoginResponse loginResponse = authService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok().body(loginResponse);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader){

        try{
            String token = authHeader.substring(7);
            AuthResponse authResponse = authService.validateToken(token);
            return ResponseEntity.ok().body(authResponse);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e);
        }
    }
}
