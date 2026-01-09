package com.example.jwt_example.service;

import com.example.jwt_example.repository.LocationRepository;
import com.example.jwt_example.repository.entity.Location;
import com.example.jwt_example.service.DTO.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    public LocationDTO mapToDTO(Location location){
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setId(location.getId());
        locationDTO.setLocation(location.getLocation());
        return locationDTO;
    }

    public Location getLocationById(Integer id){
        return locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found with id"));
    }
}
