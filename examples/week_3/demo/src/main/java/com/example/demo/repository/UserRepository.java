package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // CRUD Operations

    // Custom Query Methods
    List<User> findByName(String name);
    List<User> findByAgeGreaterThan(Integer age);
    User findByEmail(String email);
    List<User> findByNameContainingIgnoreCase(String keyword);

}
