package bridge.remote;

// Task 4: a brand-new device. Zero changes to any remote class.
public class SmartLight implements Device {
    @Override
    public void turnOn() {
        System.out.println("Smart Light glows bright white.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light shuts off.");
    }

    @Override
    public void setVolume(int level) {
        // A light has no "volume", so we reuse the same slot as brightness.
        System.out.println("Smart Light brightness set to: " + level + "%");
    }
}
