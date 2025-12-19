package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // get user by id
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Create new user
    public User createUser(User user){
        // Check if the email already exists
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    // Delete User
    public void deleteUser(Long id){
        User user = getUserById(id);
        userRepository.delete(user);
    }

    // Search by name
    public List<User> searchByName(String name){
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    // Get users older than age
    public List<User> getUsersOlderThan(Integer age){
        return userRepository.findByAgeGreaterThan(age);
    }
}
