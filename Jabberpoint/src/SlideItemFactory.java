import org.w3c.dom.Element;
public class SlideItemFactory {
    protected static final String TEXT = "text";
    protected static final String IMAGE = "image";
    protected static final String UNKNOWNTYPE = "Unknown Element type";
    public static SlideItem createSlideItemWithItemAndType(String type, int level, Element item) {
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

    public static SlideItem createSlideItemWithLevelAndContent(int level, String content) {
        if (content.endsWith(".jpg") || content.endsWith(".png")) {
            return new BitmapItem(level, content);
        } else {
            return new TextItem(level, content);
        }
    }
}