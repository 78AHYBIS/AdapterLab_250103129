import java.util.List;

public class Main {

    public static void main(String[] args) {
        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        BulbAdapter bulbAdapter = new BulbAdapter(rawBulb);
        ThermostatAdapter thermostatAdapter = new ThermostatAdapter(rawThermostat);

        List<SmartDevice> deviceList = List.of(bulbAdapter, thermostatAdapter);
        ModernHub hub = new ModernHub(deviceList);

        hub.activateAll();
        System.out.println("Bulb power: " + bulbAdapter.getPowerPercent() + "%");
        System.out.println("Thermostat power: " + thermostatAdapter.getPowerPercent() + "%");
        System.out.printf("Average power: %.2f%%%n", hub.calculateAveragePowerUsage());

        rawBulb.breakFilament();
        rawThermostat.rotateDial("STUCK");
        System.out.println("Bulb isOn after fault: " + bulbAdapter.isOn());
        System.out.println("Bulb power after fault: " + bulbAdapter.getPowerPercent());
        System.out.println("Thermostat isOn after fault: " + thermostatAdapter.isOn());
        System.out.println("Thermostat power after fault: " + thermostatAdapter.getPowerPercent());

        hub.emergencyShutdown();
        System.out.println("Bulb brightness after shutdown: " + rawBulb.readBrightness());
        System.out.println("Thermostat dial after shutdown: " + rawThermostat.checkDial());
    }
}