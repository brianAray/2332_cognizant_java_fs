package com.example.auth_server.controller;

public class LoginResponse {

    private Integer userId;
    private String token;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public LoginResponse() {
    }
}
