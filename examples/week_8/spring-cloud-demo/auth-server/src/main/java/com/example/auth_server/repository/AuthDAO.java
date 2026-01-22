package com.example.auth_server.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthDAO {

    private List<AuthEntity> authEntityList = new ArrayList<>();

    {
        authEntityList.add(new AuthEntity(1, 1, "user1", "pass1"));
        authEntityList.add(new AuthEntity(1, 2, "user2", "pass2"));
    }

    public AuthEntity getAuthEntityById(Integer id){
        for(AuthEntity authEntity: authEntityList){
            if(authEntity.getAuthId().equals(id)){
                return authEntity;
            }
        }
        return null;
    }

    public AuthEntity getAuthEntityByUsername(String username){
        for(AuthEntity authEntity: authEntityList){
            if(authEntity.getUsername().equals(username)){
                return authEntity;
            }
        }
        return null;
    }
}
