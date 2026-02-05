## Assessment 6: The Hydroponic Grow-Op API

**Domain:** Automating nutrient delivery and environment monitoring for indoor crops.

### Problem Statement

A smart farm needs an API to manage "Grow Trays." The system must prevent equipment damage by enforcing safety interlocks between the water sensors and the mechanical pumps.

**Example Grow Tray JSON:**

```json
{
  "id": "TRAY-01",
  "cropType": "Basil",
  "phLevel": 6.2,
  "waterLevelPct": 85,
  "pumpActive": false,
  "targetPh": 6.0,
  "lastNutrientDose": "2026-02-05T10:00:00Z"
}

```

### API Requirements

1. **POST `/trays`**:
* Registers a new grow tray.
* **Constraint:** `phLevel` must be between 0.0 and 14.0 .
* Response: `201 Created`.


2. **GET `/trays`**:
* Returns all trays.
* Optional Query Param: `cropType`.
* Optional Query Param: `alertStatus` (Boolean). If true, return only trays where `phLevel` deviates from `targetPh` by more than 0.5.


3. **PATCH `/trays/<id>/pump`**:
* Accepts a JSON body: `{"pumpActive": true/false}`.
* **The Trick (Safety Interlock):** If the `waterLevelPct` is **below 15%**, the API must refuse to set `pumpActive` to `true` to prevent the pump from running dry and burning out.
* Response: `200 OK` or `**409 Conflict`** with the message: "Hardware Safety Lock: Insufficient water level to engage pump."


4. **DELETE `/trays/<id>`**:
* Response: `204 No Content`.



### Implementation Steps

1. **State Validation**: In your Service layer, fetch the current Entity state before applying the PATCH. Use a conditional check to compare the *stored* water level against the *incoming* pump request.
2. **Custom Response Codes**: Utilize `HttpStatus.CONFLICT` for the safety interlock violation.
3. **Calculated Logic**: Implement the `alertStatus` filter using a custom JPQL query that calculates the absolute difference: `|phLevel - targetPh| > 0.5`.
4. **Validation Annotations**: Ensure 0.0 and 14.0 are used for pH levels, and water at 0 or 100 percentages.

