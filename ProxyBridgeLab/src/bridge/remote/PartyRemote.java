package bridge.remote;

// Task 5: a brand-new controller feature. Zero changes to Radio, SmartLight or Device.
public class PartyRemote extends BasicRemote {
    public PartyRemote(Device device) {
        super(device);
    }

    public void partyMode() {
        System.out.println("[Party Remote] Pumping up the party!");
        device.turnOn();
        device.setVolume(100);
    }
}
