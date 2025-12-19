package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
       // Clear existing data
       userRepository.deleteAll();

       // Add initial data
        userRepository.save(new User(null, "John Doe", "john@example.com", 25));
        userRepository.save(new User(null, "Jane Doe", "jane@example.com", 45));
        userRepository.save(new User(null, "Bob Doe", "bob@example.com", 65));
        userRepository.save(new User(null, "Alice Doe", "alice@example.com", 85));

        System.out.println("Loaded: " + userRepository.count() + " users");
    }
}
