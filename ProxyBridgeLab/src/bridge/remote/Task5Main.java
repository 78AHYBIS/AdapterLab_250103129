package bridge.remote;

public class Task5Main {
    public static void main(String[] args) {
        Device radio = new Radio();
        PartyRemote remote = new PartyRemote(radio);

        remote.partyMode();
    }
}
