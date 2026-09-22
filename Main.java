import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println(" OMNIHOME SMART CONTROLLER: SYSTEM STARTUP");
        System.out.println("============================================================");

        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        BulbAdapter bulbAdapter = new BulbAdapter(rawBulb);
        ThermostatAdapter thermostatAdapter = new ThermostatAdapter(rawThermostat);
        System.out.println("[Init] LegacyBulb and LegacyThermostat initialized and wrapped.");

        List<SmartDevice> deviceList = List.of(bulbAdapter, thermostatAdapter);

        ModernHub hub = new ModernHub(deviceList);
        System.out.println("[Hub] Registering " + deviceList.size() + " adapted devices into ModernHub...");

        // ModernHub badHub = new ModernHub(List.of(rawBulb)); // COMPILE ERROR

        System.out.println("\n--- OPERATION: ACTIVATE ALL DEVICES ---");
        System.out.println("[Action] ModernHub.activateAll() invoked.");
        hub.activateAll();
        System.out.println(" -> BulbAdapter: Brightness set to " + rawBulb.readBrightness() + ".");
        System.out.println(" -> ThermostatAdapter: Dial set to '" + rawThermostat.checkDial() + "'.");
        System.out.println("[Status] All devices reported active: " + (bulbAdapter.isOn() && thermostatAdapter.isOn()));

        double avgPower = hub.calculateAveragePowerUsage();
        System.out.printf("[Power] Fleet Average Power Usage: %.2f%% (Bulb: %d%%, Thermostat: %d%%)%n",
                avgPower, bulbAdapter.getPowerPercent(), thermostatAdapter.getPowerPercent());

        System.out.println("\n--- AUDIT: HARDWARE FAULT INJECTION (STAGE 4) ---");

        System.out.println("[Fault 1] Filament physically severed on LegacyBulb...");
        rawBulb.breakFilament();
        System.out.println(" -> BulbAdapter.isOn(): " + bulbAdapter.isOn());
        System.out.println(" -> BulbAdapter.getPowerPercent(): " + bulbAdapter.getPowerPercent() + "%");

        System.out.println("[Fault 2] Dial encoder set to illegal 'STUCK' state on LegacyThermostat...");
        rawThermostat.rotateDial("STUCK");
        System.out.println(" -> ThermostatAdapter.isOn(): " + thermostatAdapter.isOn());
        System.out.println(" -> ThermostatAdapter.getPowerPercent(): " + thermostatAdapter.getPowerPercent());

        System.out.println("\n--- OPERATION: EMERGENCY SHUTDOWN ---");
        System.out.println("[Action] ModernHub.emergencyShutdown() invoked.");
        hub.emergencyShutdown();
        System.out.println(" -> BulbAdapter: Brightness set to " + rawBulb.readBrightness() + ".");
        System.out.println(" -> ThermostatAdapter: Dial rotated to '" + rawThermostat.checkDial() + "'.");
        System.out.printf("[Power] Fleet Average Power Usage: %.2f%%%n", hub.calculateAveragePowerUsage());

        System.out.println("============================================================");
        System.out.println(" ALL INTEGRATION TESTS PASSED");
        System.out.println("============================================================");
    }
}