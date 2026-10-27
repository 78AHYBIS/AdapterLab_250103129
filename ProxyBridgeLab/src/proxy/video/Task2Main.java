package proxy.video;

public class Task2Main {
    public static void main(String[] args) {
        Video video = new ProxyVideo("Cat_Memes.mp4");

        video.play();
        System.out.println();
        video.play();
        System.out.println();
        video.play();
    }
}
