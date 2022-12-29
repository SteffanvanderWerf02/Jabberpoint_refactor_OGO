import java.util.ArrayList;


/**
 * <p>Presentations keeps track of the slides in a presentation.</p>
 * <p>Only one instance of this class is available.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation {
    private String showTitle; //The title of the presentation
    private SlideViewerComponent slideViewComponent; //The view component of the slides
    private SlideController slideController; //The controller of the slides
    public Presentation() {
        slideViewComponent = null;
        slideController = null;
    }

    public Presentation(SlideViewerComponent slideViewerComponent, SlideController slideController) {
        this.slideViewComponent = slideViewerComponent;
        this.slideController = slideController;
        slideController.clear();
    }

    public SlideController getSlideController() {
        return slideController;
    }
    public void setSlideController(SlideController controller) {
        this.slideController = controller;
    }

    public String getTitle() {
        return showTitle;
    }

    public void setTitle(String nt) {
        showTitle = nt;
    }

    public void setShowView(SlideViewerComponent slideViewerComponent) {
        this.slideViewComponent = slideViewerComponent;
    }

    public void updateSlideView() {
        slideViewComponent.update(this, this.slideController.getCurrentSlide());
    }
    public void exit(int n) {
        System.exit(n);
    }
}