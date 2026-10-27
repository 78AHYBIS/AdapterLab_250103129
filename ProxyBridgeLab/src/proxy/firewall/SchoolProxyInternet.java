package proxy.firewall;

// Task 3: Protection Proxy ("School Wi-Fi Firewall").
// Same Internet interface as the real thing, so students use it exactly the same way.
public class SchoolProxyInternet implements Internet {
    private RealInternet realInternet; // created lazily

    @Override
    public void connectTo(String site) {
        if (site.equals("gaming.com") || site.equals("socialmedia.com")) {
            System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
            return;
        }
        if (realInternet == null) {
            realInternet = new RealInternet();
        }
        realInternet.connectTo(site);
    }
}
