package com.example.auth_server.repository;

public class AuthEntity {
    private Integer authId;
    private Integer userId;
    private String username;
    private String password;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public AuthEntity(Integer authId, Integer userId, String username, String password) {
        this.authId = authId;
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public AuthEntity() {
    }
}
