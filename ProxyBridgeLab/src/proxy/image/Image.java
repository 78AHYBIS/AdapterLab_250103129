package proxy.image;

// The shared contract. Client code only ever sees this type,
// so it can't tell (and doesn't care) whether it holds the real object or a proxy.
public interface Image {
    void show();
}
