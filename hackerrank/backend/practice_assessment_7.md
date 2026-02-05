## Assessment 7: The Fitness Tracker API

**Domain:** Tracking individual workout sessions.

### Problem Statement

Design an API for a fitness app that logs exercises.

**Example Session JSON:**

```json
{
  "id": 1,
  "userId": 505,
  "sessionType": "Cardio",
  "workouts": [
    {
      "exerciseType": "Running",
      "durationMinutes": 45,
      "caloriesBurned": 400
    },
    {
      "exerciseType": "Elliptical",
      "durationMinutes": 45,
      "caloriesBurned": 300
    }
  ],
  "date": "2026-01-28"
}

```


### API Requirements

1. **POST `/{userId}/workouts`**:
* Creates a new workout log.
* Response: `201 Created`.

2. **GET `/{userId}/workouts`**:
* Returns all logs for a user.
* Optional Query Params: `sessionType`.
* Response: `200 OK`.

3. **GET `/{userId}/workouts/{id}`**:
* Returns a workout by ID.
* Response: `200 OK` or `404 Not Found`.

4. **PUT/PATCH `/{userId}/workouts/{id}`**
* Updates a session
* Response: `200 OK` or `404 Not Found`

5. **DELETE `/{userId}/workouts/{id}`**
* Deletes a session
* Response: `200 OK` or `404 Not Found`


### Implementation Steps

1. **Setup**: Set up a Spring Boot project including Spring Web, Spring Data JPA, and a database driver (like H2 or PostgreSQL).
2. **Model**: 
  - Create a `WorkoutSession` entity.
  - Create a `WorkoutItem` (or `Exercise`) entity to represent the nested list.
  - Establish a One-to-Many relationship between the Session and the Workout items, ensuring `CascadeType.ALL` is used for persistence.
3. **Repository**:
  - Define a WorkoutRepository that extends JpaRepository.
  - Add custom query methods to support filtering by userId, sessionType, and date ranges.
4. **DTO**: Create a WorkoutSessionRequestDTO and a WorkoutItemDTO to decouple the API contract from the database schema.
5. **Service**: Implement business logic
6. **Controller**: implement the endpoints
7. **Database**: Configure `application.properties` to set up the data source and ensure the schema is generated automatically for testing.