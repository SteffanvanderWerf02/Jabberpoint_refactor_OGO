import java.util.ArrayList;

public class SlideController {
    private ArrayList<Slide> showList; //An ArrayList with slides
    private int currentSlideNumber; //The number of the current slide

    public SlideController() {
        this.showList = new ArrayList<>();
        this.currentSlideNumber = 0;
    }

    public int getSize() {
        return showList.size();
    }

    //Returns the number of the current slide
    public int getSlideNumber() {
        return currentSlideNumber;
    }

    //Change the current slide number and report it the window
    public void setSlideNumber(int number) {
        // If the number is out of range, do nothing
        if (SlideExists(number)) {
            currentSlideNumber = number;
        }
    }

    //Navigate to the previous slide unless we are at the first slide
    public void prevSlide() {
        if (currentSlideNumber > 0) {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    //Navigate to the next slide unless we are at the last slide
    public void nextSlide() {
        if (currentSlideNumber < (showList.size() - 1)) {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    //Remove the presentation
    public void clear() {
        showList = new ArrayList<>();
        setSlideNumber(-1);
    }

    //Add a slide to the presentation
    public void append(Slide slide) {
        showList.add(slide);
    }

    //Return a slide with a specific number
    public Slide getSlide(int number) {
        return showList.get(number);
    }

    // Check if a slide exists
    public boolean SlideExists(int number) {
        return number >= 0 && number < getSize();
    }

    //Return the current slide
    public Slide getCurrentSlide() {
        return showList.get(currentSlideNumber);
    }

}