package proxy.video;

// Task 2: Logging/Tracking Proxy ("The View Counter").
// Counts plays without RealVideo knowing anything about analytics.
public class ProxyVideo implements Video {
    private final String fileName;
    private RealVideo realVideo; // lazy: created on the first play()
    private int viewCount = 0;

    public ProxyVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        viewCount++;
        System.out.println("--> [AUDIT] Video has been played " + viewCount + " time(s).");

        if (realVideo == null) {
            realVideo = new RealVideo(fileName); // download happens only once
        }
        realVideo.play();
    }
}
