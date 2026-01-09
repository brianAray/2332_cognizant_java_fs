package com.example.jwt_example.service.DTO;

import java.util.Objects;

public class LocationDTO {
    private Integer id;
    private String location;

    @Override
    public String toString() {
        return "LocationDTO{" +
                "id=" + id +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDTO that = (LocationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationDTO(Integer id, String location) {
        this.id = id;
        this.location = location;
    }

    public LocationDTO() {
    }
}
