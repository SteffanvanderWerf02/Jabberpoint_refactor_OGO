public class PresentationFactory {
    public static Presentation createPresentation() {
        Presentation presentation = new Presentation(new SlideController());
        new SlideViewerFrame(JabberPoint.JABVERSION, presentation);

        return presentation;
    }
}