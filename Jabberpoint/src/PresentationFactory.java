import Utility.Utility;

public class PresentationFactory {
    public static Presentation createPresentation() {
        Presentation presentation = new Presentation(new SlideController());
        new SlideViewerFrame(Utility.JABVERSION, presentation);

        return presentation;
    }

    public static void addSlideViewerComponent(Presentation presentation, SlideViewerComponent slideViewerComponent) {
        presentation.setShowView(slideViewerComponent);
    }
}