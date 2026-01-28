## Assessment 3: The Fitness Activity Logger

**Backend Base:** The Fitness Tracker API (POST/GET/DELETE).
**Frontend Goal:** Build a dynamic dashboard to log workouts and manage a real-time activity list.

### Pre Steps

Before building the frontend, populate your backend database with initial data to ensure your list components have content to render.

Create a bash script to execute this:

`seed_workouts.sh`

```bash
#!/bin/bash

# Configuration
API_URL="http://localhost:8080/workouts"
DATE=$(date +%Y-%m-%d)

echo "Starting workout data seeding to $API_URL..."

# Array of workout data: userId|exerciseType|durationMinutes|caloriesBurned
workouts=(
  "505|Running|45|400"
  "505|Cycling|60|550"
  "102|Swimming|30|300"
  "204|Yoga|50|150"
  "102|Weightlifting|40|250"
  "303|Walking|20|100"
)

for workout in "${workouts[@]}"; do
  IFS="|" read -r uid type dur cal <<< "$workout"

  echo "Posting $type workout for User $uid..."

  curl --location "$API_URL" \
    --header 'Content-Type: application/json' \
    --data "{
        \"userId\": $uid,
        \"exerciseType\": \"$type\",
        \"durationMinutes\": $dur,
        \"caloriesBurned\": $cal,
        \"date\": \"$DATE\"
    }"
  
  echo -e "\n Done."
done

echo "Workout seeding complete!"

```

1. **Start your Spring Boot backend** (Ensure the `/workouts` endpoint is active).
2. **Run** `chmod +x seed_workouts.sh` in your terminal to make the script executable.
3. **Run** `./seed_workouts.sh` in your terminal.
4. **Verify** via the browser or Postman (`GET http://localhost:8080/workouts`).

### Requirement Steps

1. **The Dynamic Form:** - Create a `WorkoutFormComponent` with inputs for `exerciseType` (dropdown), `durationMinutes` (number), `caloriesBurned` (number), and `userId` (number).
* Ensure all fields are cleared after a successful submission.

2. **Conditional Field Logic:** - Add a checkbox labeled **"High Intensity Session"**.
* Use conditional logic so that an additional input field for `peakHeartRate` appears **only** when this checkbox is checked.

3. **Data Submission:** - On clicking "Save", the component should send a `POST` request to the `/workouts` endpoint.
* Handle the response: display a success message if the code is `201 Created`.


4. **Local State Update:** - In your `WorkoutListComponent`, view a list of workouts from the backend.
* **Optimization:** When a new workout is added via the form, instead of refreshing the entire page, push the new object returned by the API directly into the displayed array.


5. **Row Deletion:** - Each row in your workout table must have a **"Delete"** button.
* Clicking this button should call the `DELETE /workouts/<id>` endpoint.
* On a successful deletion, remove that specific item from the frontend list immediately.
