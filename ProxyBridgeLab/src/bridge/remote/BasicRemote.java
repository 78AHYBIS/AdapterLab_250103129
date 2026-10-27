package bridge.remote;

// Abstraction side of the bridge: what the USER can press.
// The `device` field IS the bridge: the remote never knows which concrete machine it drives.
public class BasicRemote {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.turnOn();
    }

    public void powerOff() {
        device.turnOff();
    }
}
