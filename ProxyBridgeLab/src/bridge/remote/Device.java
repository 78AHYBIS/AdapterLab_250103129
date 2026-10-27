package bridge.remote;

// Implementor side of the bridge: what a machine can DO.
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}
