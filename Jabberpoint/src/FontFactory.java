import java.awt.*;

public class FontFactory {
    public static Font createFont(String name, int style, int size) {
        return new Font(name, style, size);
    }
}