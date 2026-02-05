## Assessment 8: The Smart Home Dashboard

**Backend Base:** The Smart Home API.
**Frontend Goal:** Create a dashboard to toggle device states and manage room layouts.

### Pre-Steps: Data Seeding

Create a file named `seed_smart_home.sh` to populate your database with initial rooms and devices.

```bash
#!/bin/bash

BASE_URL="http://localhost:8080"
DATE_NOW=$(date +%Y-%m-%d)

echo "Starting expanded Smart Home data seeding..."

post_room() {
  local userId=$1
  local json_payload=$2
  
  echo "Adding room for User $userId..."
  curl -s -X POST "$BASE_URL/$userId/rooms" \
    -H "Content-Type: application/json" \
    -d "$json_payload"
  echo -e "\nDone."
}

# --- USER 88 (The Power User) ---
post_room 88 "{
  \"roomName\": \"Home Theater\",
  \"lastUpdated\": \"$DATE_NOW\",
  \"devices\": [
    { \"deviceName\": \"4K Projector\", \"deviceType\": \"Entertainment\", \"powerUsageWatts\": 350, \"status\": \"ON\" },
    { \"deviceName\": \"Surround Sound\", \"deviceType\": \"Entertainment\", \"powerUsageWatts\": 150, \"status\": \"ON\" },
    { \"deviceName\": \"Smart Blinds\", \"deviceType\": \"Security\", \"powerUsageWatts\": 5, \"status\": \"OFF\" }
  ]
}"

post_room 88 "{
  \"roomName\": \"Garage\",
  \"lastUpdated\": \"$DATE_NOW\",
  \"devices\": [
    { \"deviceName\": \"EV Charger\", \"deviceType\": \"Appliance\", \"powerUsageWatts\": 7000, \"status\": \"ON\" },
    { \"deviceName\": \"Workshop Heater\", \"deviceType\": \"Climate\", \"powerUsageWatts\": 1500, \"status\": \"OFF\" }
  ]
}"

# --- USER 99 (The Apartment Dweller) ---
post_room 99 "{
  \"roomName\": \"Studio Main\",
  \"lastUpdated\": \"$DATE_NOW\",
  \"devices\": [
    { \"deviceName\": \"Smart Bulb 1\", \"deviceType\": \"Lighting\", \"powerUsageWatts\": 9, \"status\": \"ON\" },
    { \"deviceName\": \"Laptop Dock\", \"deviceType\": \"Appliance\", \"powerUsageWatts\": 90, \"status\": \"ON\" },
    { \"deviceName\": \"Portable AC\", \"deviceType\": \"Climate\", \"powerUsageWatts\": 1100, \"status\": \"ON\" }
  ]
}"

# --- USER 101 (The Security Focused) ---
post_room 101 "{
  \"roomName\": \"Exterior\",
  \"lastUpdated\": \"$DATE_NOW\",
  \"devices\": [
    { \"deviceName\": \"Front Door Camera\", \"deviceType\": \"Security\", \"powerUsageWatts\": 12, \"status\": \"ON\" },
    { \"deviceName\": \"Floodlights\", \"deviceType\": \"Lighting\", \"powerUsageWatts\": 100, \"status\": \"OFF\" },
    { \"deviceName\": \"Smart Lock\", \"deviceType\": \"Security\", \"powerUsageWatts\": 2, \"status\": \"ON\" }
  ]
}"

# --- USER 202 (The Eco-Conscious) ---
post_room 202 "{
  \"roomName\": \"Greenhouse\",
  \"lastUpdated\": \"$DATE_NOW\",
  \"devices\": [
    { \"deviceName\": \"Hydroponic Pump\", \"deviceType\": \"Appliance\", \"powerUsageWatts\": 45, \"status\": \"ON\" },
    { \"deviceName\": \"UV Grow Light\", \"deviceType\": \"Lighting\", \"powerUsageWatts\": 60, \"status\": \"ON\" }
  ]
}"

post_room 202 "{
  \"roomName\": \"Laundry\",
  \"lastUpdated\": \"$DATE_NOW\",
  \"devices\": [
    { \"deviceName\": \"Smart Washer\", \"deviceType\": \"Appliance\", \"powerUsageWatts\": 500, \"status\": \"OFF\" },
    { \"deviceName\": \"Electric Dryer\", \"deviceType\": \"Appliance\", \"powerUsageWatts\": 3000, \"status\": \"OFF\" }
  ]
}"

echo "Expanded seeding complete! Total Users: 4 | Total Rooms: 6"

```

1. **Start Backend**: Ensure your Spring Boot app is running on port 8080.
2. **Make Executable**: `chmod +x seed_smart_home.sh`.
3. **Run Script**: `./seed_smart_home.sh`.

### Requirement Steps

1. **Component Architecture**:
* `UserAuth`: Simple input to "log in" via `userId`.
* `RoomGrid`: A layout displaying cards for each room.
* `DeviceControl`: A component within the room card to toggle `ON/OFF` status.
* `DeviceForm`: A modal or nested form to add new devices to a room.


2. **Dynamic Form**:
* The `DeviceForm` must include a dropdown for `deviceType` (Lighting, Climate, Appliance, Security) and a number input for `powerUsageWatts`.


3. **Conditional Styling (Power Alert)**:
* If a device's `powerUsageWatts` is greater than **1000**, display a **"High Energy"** badge in red.
* If the device `status` is "OFF", grey out the device icon.


4. **Data Submission**:
* Handle `PATCH` requests when a user toggles a device status.
* Handle `POST` requests to create new rooms.


5. **State Management**:
* When a device is deleted or updated, the `RoomGrid` should reflect the changes immediately without a full page reload.
* Display the "Total Room Power Usage" at the bottom of each room card using the API.