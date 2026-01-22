package com.example.order_service;

public class AuthResponse {
    private String token;
    private Boolean isValid;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public AuthResponse(String token, Boolean isValid) {
        this.token = token;
        this.isValid = isValid;
    }

    public AuthResponse() {
    }
}
