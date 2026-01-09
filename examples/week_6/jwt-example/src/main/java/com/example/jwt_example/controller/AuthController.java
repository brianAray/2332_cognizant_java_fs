package com.example.jwt_example.controller;

import com.example.jwt_example.controller.request.LoginRequest;
import com.example.jwt_example.controller.response.LoginResponse;
import com.example.jwt_example.service.AuthService;
import com.example.jwt_example.service.DTO.UserDTO;
import com.example.jwt_example.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private AuthService authService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> simpleLogin(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authService.validateLogin(loginRequest.getUsername(), loginRequest.getPassword());

        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/protected")
    public ResponseEntity<?> protectedEndpoint(@RequestHeader("Authorization") String authHeader){
        try{
            String token = authHeader.substring(7); // Bearer token-string

            // Validate Token
            if(!jwtUtil.validateToken(token)){
                throw new RuntimeException("Invalid Token");
            }

            Map<String, String> data = new HashMap<>();
            data.put("username", jwtUtil.extractUsername(token));

            return ResponseEntity.ok(data);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Token");
        }
    }
}
