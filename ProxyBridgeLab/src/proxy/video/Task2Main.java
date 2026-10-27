package proxy.video;

public class Task2Main {
    public static void main(String[] args) {
        Video video = new ProxyVideo("Cat_Memes.mp4");

        video.play(); // audit 1 + download + play
        System.out.println();
        video.play(); // audit 2 + play (already buffered)
        System.out.println();
        video.play(); // audit 3 + play
    }
}
