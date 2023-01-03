import org.w3c.dom.Element;
public class SlideFactory {
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    public static SlideItem createSlideItem(String type, int level, Element item) {
        if (TEXT.equals(type)) {
            return new TextItem(level, item.getTextContent());
        } else {
            if (IMAGE.equals(type)) {
                return new BitmapItem(level, item.getTextContent());
            } else {
                System.err.println(UNKNOWNTYPE);
            }
        }

        return null;
    }

    public static void appendSlideItem(SlideItem item,Slide slide) {
        slide.append(item);
    }
}