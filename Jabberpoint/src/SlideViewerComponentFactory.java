import javax.swing.*;

public class SlideViewerComponentFactory {
    public static SlideViewerComponent createSlideViewerComponent(Presentation presentation, JFrame frame) {
        return new SlideViewerComponent(presentation, frame);
    }
}