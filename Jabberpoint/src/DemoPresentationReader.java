public class DemoPresentationReader extends Reader {


    public void loadFile(Presentation presentation, String unusedFilename) {
        presentation.setTitle("Demo Presentation");
        Slide slide = SlideFactory.createSlide();

        slide.setTitle("JabberPoint");
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "JabberPoint is a Java application for presenting slides."), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "The Java presentation tool."), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(2, "Copyright (c) 1996-2000: Ian Darwin"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(2, "Copyright (c) 2000-now:"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(2, "Gert Florijn and Sylvia Stuurman"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(4, "Calling Jabberpoint without a filename"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(4, "will show this presentation"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "Navigate:"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(3, "Next slide: PgDn or Enter"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(3, "Previous slide: PgUp or up-arrow"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(3, "Quit: q or Q"), slide);
        presentation.getSlideController().append(slide);

        slide = SlideFactory.createSlide();
        slide.setTitle("Demonstration of levels and styles");
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "Level 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(2, "Level 2"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "Again level 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "Level 1 has style number 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(2, "Level 2 has style number 1"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(3, "This is how level 3 looks like"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(4, "And this is level 4"), slide);
        presentation.getSlideController().append(slide);

        slide = SlideFactory.createSlide();
        slide.setTitle("The third slide");
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "To open a new presentation,"), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(2, "use File->Open from the menu."), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, " "), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "This is the end of the presentation."), slide);
        SlideFactory.appendSlideItemToSlide(SlideItemFactory.createSlideItemWithLevelAndContent(1, "JabberPoint.jpg"), slide);
        presentation.getSlideController().append(slide);
    }

}