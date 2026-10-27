package proxy.video;

// The expensive object: downloading/buffering happens once, in the constructor.
public class RealVideo implements Video {
    private final String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;
        System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + fileName);
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + fileName);
    }
}
