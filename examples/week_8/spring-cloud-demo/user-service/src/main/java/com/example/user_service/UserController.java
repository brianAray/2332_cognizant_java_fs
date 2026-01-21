package com.example.user_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    {
        users.add(new User(1, "Jim", "jim@email.com"));
        users.add(new User(2, "Jane", "jane@email.com"));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        for(User user: users){
            if(user.getId().equals(id)){
                return ResponseEntity.ok().body(user);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Exception("Not found"));
    }
}
