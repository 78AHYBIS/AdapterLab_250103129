package proxy.image;

// Task 1: Protection Proxy ("The Bouncer").
// Checks the caller's role BEFORE the expensive RealImage is even created.
public class ProxyImage implements Image {
    private final String fileName;
    private final String userRole;
    private RealImage realImage; // stays null until an authorized user needs it

    public ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    @Override
    public void show() {
        // Security check first: a denied user must never trigger the slow disk read.
        if (!"ADMIN".equals(userRole)) {
            System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
            return;
        }
        // Lazy loading: create the real object only on first authorized use.
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.show();
    }
}
