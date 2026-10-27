package bridge.remote;

public class Task4Main {
    public static void main(String[] args) {
        Device light = new SmartLight();
        AdvancedRemote remote = new AdvancedRemote(light);

        remote.powerOn();
        remote.mute();
    }
}
