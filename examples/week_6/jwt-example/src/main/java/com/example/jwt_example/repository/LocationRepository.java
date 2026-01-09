package com.example.jwt_example.repository;

import com.example.jwt_example.repository.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByLocation(String location);
    boolean existsByLocation(String location);
}
