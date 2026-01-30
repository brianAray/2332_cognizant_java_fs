## Assessment 3: The Fitness Activity Logger

**Backend Base:** The Fitness Tracker API (POST/GET/PUT/PATCH/DELETE).
**Frontend Goal:** Build a dynamic dashboard to log workouts and manage a real-time activity list.

### Pre Steps

Before building the frontend, populate your backend database with initial data to ensure your list components have content to render.

Create a bash script to execute this:

`seed_workouts.sh`

```bash
#!/bin/bash

BASE_URL="http://localhost:8080"
DATE_TODAY=$(date +%Y-%m-%d)
DATE_YESTERDAY=$(date -d "yesterday" +%Y-%m-%d 2>/dev/null || date -v-1d +%Y-%m-%d)

echo "Starting workout data seeding to $BASE_URL..."

# Helper function to post a session
post_session() {
  local userId=$1
  local json_payload=$2
  
  echo "Posting session for User $userId..."
  curl -s -X POST "$BASE_URL/$userId/workouts" \
    -H "Content-Type: application/json" \
    -d "$json_payload"
  echo -e "\n¿? Done.\n"
}

# --- USER 505 ---
post_session 505 "{
  \"sessionType\": \"Cardio\",
  \"date\": \"$DATE_TODAY\",
  \"workouts\": [
    { \"exerciseType\": \"Running\", \"durationMinutes\": 45, \"caloriesBurned\": 400 },
    { \"exerciseType\": \"Elliptical\", \"durationMinutes\": 15, \"caloriesBurned\": 120 }
  ]
}"

# --- USER 102 ---
post_session 102 "{
  \"sessionType\": \"Swimming\",
  \"date\": \"$DATE_YESTERDAY\",
  \"workouts\": [{ \"exerciseType\": \"Laps\", \"durationMinutes\": 40, \"caloriesBurned\": 500 }]
}"

post_session 102 "{
  \"sessionType\": \"Strength\",
  \"date\": \"$DATE_TODAY\",
  \"workouts\": [{ \"exerciseType\": \"Weightlifting\", \"durationMinutes\": 60, \"caloriesBurned\": 300 }]
}"

# --- USER 204 ---
post_session 204 "{
  \"sessionType\": \"Flexibility\",
  \"date\": \"$DATE_TODAY\",
  \"workouts\": [{ \"exerciseType\": \"Yoga\", \"durationMinutes\": 50, \"caloriesBurned\": 180 }]
}"

# --- USER 303 ---
post_session 303 "{
  \"sessionType\": \"Recovery\",
  \"date\": \"$DATE_TODAY\",
  \"workouts\": [{ \"exerciseType\": \"Walking\", \"durationMinutes\": 30, \"caloriesBurned\": 110 }]
}"

echo "Seeding complete!"


```

This will generate 4 users with their own workouts:
- User Id:
  - 505
  - 102
  - 204
  - 303

1. **Start your Spring Boot backend** (Ensure the `/workouts` endpoint is active).
2. **Run** `chmod +x seed_workouts.sh` in your terminal to make the script executable.
3. **Run** `./seed_workouts.sh` in your terminal.
4. **Verify** via the browser or Postman (`GET http://localhost:8080/workouts`).

### Requirement Steps

1. **Component Architecture:** 
    - A `LoginComponent` to enter in the userId and store it as a state variable to be by other components
    - A `SessionGalleryComponent` to view all the sessions for a user
    - A `WorkoutListComponent` to view the workouts associated with a session
    - A `SessionFormComponent` to create a new session for the user or edit a session
    - A `WorkoutFormComponent` to create a new or update an existing session
2. **Dynamic Form:**
  - The `WorkoutFormComponent` should have inputs for `exerciseType` (dropdown or enter in custom type), `durationMinutes` (number), `caloriesBurned` (number). The `userId` (number) is required to be filled through a state variable.
  - Each workout will be added to the session
  - Ensure all fields are cleared after a successful submission.
3. **Conditional Field Logic:** 
  - Add a conditional label **"High Intensity"** and styling.
  - Use conditional logic so that it flags an exercise as **"High Intensity"**: `caloriesBurned` >= 200 && `durationMinutes` <= 10
4. **Data Submission:** 
  - On clicking "Save", the component should send a `POST` request to the `/workouts` endpoint with the correct `userId`
  - Handle the response: display a success message if the code is `201 Created` and an unsuccessful message if it is not.
5. **Local State Update:** - In your `SessionComponent`, view a list of sessions from the backend
  - When the session is clicked, it will expand the sessions workouts so that they are displayed
  - Each session will have an edit option that will let you update the workouts individually or remove them from the session
  - Each session can be deleted as well
  - Clicking a save button will trigger the request to the backend to handle the local state update
