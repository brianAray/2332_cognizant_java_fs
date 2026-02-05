## Assessment 6: The Farm Controller

**Backend Base:** The Hydroponic Grow-Op API.
**Frontend Goal:** A high-visibility "Command Center" for greenhouse technicians.

### Pre-Steps

Seed your greenhouse with the following data:

`seed_greenhouse.sh`

```bash
#!/bin/bash

API_URL="http://localhost:8080/trays"

echo "Initializing Greenhouse Trays..."

# Data: ID|Crop|pH|Water%|Pump|TargetPH
trays=(
  "TRAY-01|Basil|6.2|85|false|6.0"
  "TRAY-02|Lettuce|5.8|12|false|6.5"
  "TRAY-03|Kale|7.2|45|true|6.8"
  "TRAY-04|Basil|4.5|90|false|6.0"
  "TRAY-05|Arugula|6.4|5|false|6.2"
)

for t in "${trays[@]}"; do
  TIMESTAMP=$(date -u +"%Y-%m-%dT%H:%M:%SZ") # Generate ISO 8601 timestamp
  IFS="|" read -r id crop ph water pump target <<< "$t"

  curl --location "$API_URL" \
    --header 'Content-Type: application/json' \
    --data "{
        \"id\": \"$id\",
        \"cropType\": \"$crop\",
        \"phLevel\": $ph,
        \"waterLevelPct\": $water,
        \"pumpActive\": $pump,
        \"targetPh\": $target,
        \"lastNutrientDose\": \"$TIMESTAMP\"
    }"
  echo -e "\nTray $id Configured with timestamp: $TIMESTAMP"
done

```

1. **Start your backend.**
2. **Execute:** `chmod +x seed_greenhouse.sh && ./seed_greenhouse.sh`.
3. **Verify:** Check `GET http://localhost:8080/trays`.

### Requirement Steps

1. **Telemetry Cards**: Display each tray card with a vertical progress bar.
* **Blue:** Water > 15 %.
* **Red:** Water <= 15 %.


2. **The pH Gauge**: Create a component that shows the `phLevel`.
* If the difference between `phLevel` and `targetPh` is > 0.5 , display a "Chemical Imbalance" warning icon.


3. **Pump Control Toggle**:
* Provide a toggle switch for `pumpActive`.
* **Error Handling:** If the user tries to toggle the pump on a tray with low water () and the API returns a `409`, show a **persistent Error Banner** at the top of the screen: "CRITICAL: Pump Engagement Prevented - Check Water Reservoirs."


4. **Dynamic Filtering**:
* Create a "Needs Attention" button. When clicked, it should call the `alertStatus=true` endpoint to filter the UI to only problematic trays.