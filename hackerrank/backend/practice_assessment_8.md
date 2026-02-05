## Assessment 8: The Smart Home Device Manager

**Domain:** Managing smart devices categorized by rooms within a household.

### Problem Statement

Design an API for a smart home system that allows users to organize their devices into rooms (e.g., Kitchen, Bedroom) and manage the status of those devices.

**Example Room JSON:**

```json
{
  "id": 10,
  "userId": 88,
  "roomName": "Living Room",
  "devices": [
    {
      "deviceName": "Smart Bulb",
      "deviceType": "Lighting",
      "powerUsageWatts": 9,
      "status": "ON"
    },
    {
      "deviceName": "AC Unit",
      "deviceType": "Climate",
      "powerUsageWatts": 1200,
      "status": "OFF"
    }
  ],
  "lastUpdated": "2026-02-05"
}

```

### Available Status
- **ON**
- **OFF**

### API Requirements

1. **POST `/{userId}/rooms`**:
* Creates a new room configuration.
* Response: `201 Created`.


2. **GET `/{userId}/rooms`**:
* Returns all rooms for a specific user.
* Optional Query Params: `roomName`.
* Response: `200 OK`.


3. **GET `/{userId}/rooms/{id}`**:
* Returns a specific room and its devices.
* Response: `200 OK` or `404 Not Found`.


4. **PUT/PATCH `/{userId}/rooms/{id}`**:
* Updates room details or the list of devices.
* Response: `200 OK` or `404 Not Found`.


5. **DELETE `/{userId}/rooms/{id}`**:
* Deletes a room and all associated devices.
* Response: `204 No Content` or `404 Not Found`.



### Implementation Steps

1. **Setup**: Initialize a Spring Boot project with Spring Web, Spring Data JPA, and H2/PostgreSQL.
2. **Model**:
* Create a `HomeRoom` entity.
* Create a `SmartDevice` entity.
* Establish a **One-to-Many** relationship where one room has many devices. Use `orphanRemoval = true` to ensure devices are deleted if removed from the list.


3. **Repository**: Define a `RoomRepository` extending `JpaRepository` with custom finders for `userId`.
4. **DTO**: Use `RoomDTO` and `DeviceDTO` to prevent circular reference issues during JSON serialization.
5. **Service**: Implement logic to calculate total power consumption for a room (sum of `powerUsageWatts` for devices that are "ON").
6. **Controller**: Build the REST endpoints following the paths above.
7. **Database**: Configure `application.properties` to show SQL logs for easier debugging.
