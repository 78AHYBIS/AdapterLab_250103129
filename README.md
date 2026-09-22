# CSS 217 — Adapter Pattern Lab: OmniHome Smart Controller

Object Adapter (GoF structural pattern) implementation bridging two legacy
smart-home devices to a modern unified interface, without modifying any
vendor/client code.

## Scenario

`ModernHub` (the client) only knows how to operate devices through the
`SmartDevice` interface. Two legacy devices don't implement it and can't be
changed:

- `LegacyBulb` — raw 0–255 brightness scale, boolean filament status
- `LegacyThermostat` — discrete string dial states (`IDLE`, `LOW`, `MEDIUM`, `MAX`)

## Files

| File | Role | Status |
|---|---|---|
| `SmartDevice.java` | Target interface | provided, unmodified |
| `LegacyBulb.java` | Adaptee A | provided, unmodified |
| `LegacyThermostat.java` | Adaptee B | provided, unmodified |
| `ModernHub.java` | Client | provided, unmodified |
| `BulbAdapter.java` | Adapter A | authored |
| `ThermostatAdapter.java` | Adapter B | authored |
| `Main.java` | Driver / integration test | authored |

## Design notes

- **Object Adapter, not Class Adapter**: adapters hold the legacy object as a
  private `final` field (composition) and implement `SmartDevice`, rather than
  trying to inherit from both. Java has no multiple inheritance, and the
  legacy classes are off-limits anyway — composition is the only viable route.
- **Power calibration (`BulbAdapter`)**: `min(100, floor(raw*100/255) + K)`,
  where `K = 9` (last digit of student ID 250103129). Zero brightness always
  returns 0% regardless of `K`.
- **Fault tolerance**: adapters actively defend against bad legacy state
  (severed filament reporting stale brightness; corrupted/null dial strings)
  so `ModernHub` never sees an exception or a nonsensical reading.

## Build & run

```bash
mkdir -p bin
javac -d bin *.java
java -cp bin Main
```

## Status

- [ ] Stage 1 — `BulbAdapter` + calibrated power conversion (K = 9)
- [ ] Stage 2 — `ThermostatAdapter` state/type translation
- [ ] Stage 3 — `Main.java` polymorphic integration + type-safety reflection comment
- [ ] Stage 4 — defensive fault handling (severed filament, corrupted/null dial)
- [ ] Compiled and run locally
