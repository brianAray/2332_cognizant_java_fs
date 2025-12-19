package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getALlUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get User By ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
       User user = userService.getUserById(id);
       return ResponseEntity.ok(user);
    }

    // POST create a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Get serach by name
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchByName(@RequestParam String name){
        List<User> users = userService.searchByName(name);
        return ResponseEntity.ok(users);
    }

    // Get older than age
    @GetMapping("/older-than")
    public ResponseEntity<List<User>> getUsersOlderThan(@RequestParam Integer age){
        List<User> users = userService.getUsersOlderThan(age);
        return ResponseEntity.ok(users);
    }

}
