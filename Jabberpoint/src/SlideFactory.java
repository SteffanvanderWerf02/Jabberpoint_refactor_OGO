public class SlideFactory {
    public static Slide createSlide() {
        return new Slide();
    }

    public static void appendSlideItemToSlide(SlideItem item, Slide slide) {
        slide.append(item);
    }
}