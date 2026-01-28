## Assessment 3: The Fitness Tracker API

**Domain:** Tracking individual workout sessions.

### Problem Statement

Design an API for a fitness app that logs exercises.

**Example Workout JSON:**

```json
{
  "id": 1,
  "userId": 505,
  "exerciseType": "Running",
  "durationMinutes": 45,
  "caloriesBurned": 400,
  "date": "2026-01-28"
}

```

### API Requirements

1. **POST `/workouts**`:
* Creates a new workout log.
* Response: `201 Created`.


2. **GET `/workouts**`:
* Returns all logs.
* Optional Query Params: `userId` and `exerciseType`.
* Response: `200 OK`.


3. **GET `/workouts/<id>**`:
* Returns a workout by ID.
* Response: `200 OK` or `404 Not Found`.


4. **DELETE/PUT/PATCH `/workouts/<id>**`:
* Response: `405 Method Not Allowed`.



### Implementation Steps

1. **Setup**: Initialize a Spring Boot project with Web, JPA, and H2 dependencies.
2. **Model**: Create the entity with the fields specified above.
3. **Repository**: Create a repository extending `JpaRepository`.
4. **Service**: Implement logic to handle "find all" with filtering logic.
5. **Controller**: Map the endpoints and ensure the 405 status code is explicitly handled for prohibited methods.
6. **Setup**: Configure `application.properties` for an in-memory H2 database.
7. **DTO Pattern**: Use a Data Transfer Object (DTO) for the request body and map it to your Entity.
8. **Filtering**: Implement a service method that checks if the relevant field is present; if so, filter the list before returning.
9. **Error Handling**: Create a Global Exception Handler or use `ResponseEntity` in the controller to manage the 405 and 404 responses.
10. **Validation**: Ensure that there is relevant validation handling to prevent values from being ones that are not following the business logic.