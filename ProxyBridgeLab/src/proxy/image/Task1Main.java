package proxy.image;

public class Task1Main {
    public static void main(String[] args) {
        Image guestView = new ProxyImage("salary_sheet.png", "GUEST");
        Image adminView = new ProxyImage("salary_sheet.png", "ADMIN");

        guestView.show(); // blocked, RealImage is never created
        adminView.show(); // allowed: lazy-loads, then displays
    }
}
