## Assessment 2: The City Weather Portal

**Backend Base:** The Weather Sensor API (Search by City Name).
**Frontend Goal:** A search bar that fetches city data and displays visual "Weather Cards."

### Pre Steps

Populate the backend database with some relevant data to make the searching more practical.
Create a bash script to execute this:

`seed_weather.sh`

```bash
#!/bin/bash

# Configuration
API_URL="http://localhost:8080/weather"
TIMESTAMP=$(date +%s000) # Current epoch time in milliseconds

echo "Starting weather data seeding to $API_URL..."

# Array of city data: Name|Lat|Long|Temp
cities=(
  "London|51.5074|-0.1278|15.5"
  "New York|40.7128|-74.0060|22.3"
  "Tokyo|35.6895|139.6917|18.2"
  "Sydney|-33.8688|151.2093|25.4"
  "Dallas|32.7767|-96.7970|31.0"
  "Oakland|37.8044|-122.2712|19.5"
  "Paris|48.8566|2.3522|14.0"
  "Dubai|25.2048|55.2708|38.0"
)

for city_info in "${cities[@]}"; do
  IFS="|" read -r name lat long temp <<< "$city_info"

  echo "Posting data for $name..."

  curl --location "$API_URL" \
    --header 'Content-Type: application/json' \
    --data "{
        \"cityName\": \"$name\",
        \"latitude\": $lat,
        \"longitude\": $long,
        \"temperature\": $temp,
        \"timestamp\": $TIMESTAMP
    }"
  
  echo -e "\n Done."
done

echo "Seeding complete!"
```
1. **Start your backend** (Ensure the `/weather` endpoint is ready).
2. **Run** `chmod +x seed_weather.sh` in your terminal to make the script executable.
3. **Run** `./seed_weather.sh` in your terminal.
4. **Verify** via the browser or Postman (`GET http://localhost:8080/books`).

### Requirement Steps

1. **Search Integration:** Bind an input field to a "Search" button. When clicked, call your Spring Boot `GET /weather?cityName=London`.
2. **Parsing Backend Data:** Your Spring Boot API returns a temperature integer. On your frontend, create a function that returns a CSS class:
* If `temp < 15`, return `cold-theme` (blue background).
* If `temp >= 15`, return `warm-theme` (orange background).

3. **Icon Logic:** Use a conditional check to show a sun icon or a snowflake icon based on the temperature value returned by your API.
4. **Error Handling:** If the Spring Boot API returns a `404 Not Found` (meaning the city doesn't exist in the DB), display a "City Not Recorded" alert.

