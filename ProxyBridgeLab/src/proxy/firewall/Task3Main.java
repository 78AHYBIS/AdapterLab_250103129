package proxy.firewall;

public class Task3Main {
    public static void main(String[] args) {
        Internet internet = new SchoolProxyInternet();

        internet.connectTo("wikipedia.org");
        internet.connectTo("gaming.com");
    }
}
