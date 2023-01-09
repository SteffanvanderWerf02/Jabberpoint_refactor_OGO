import Utility.ErrorMessage;
import org.w3c.dom.Element;

public class SlideItemFactory {
    private static final String TEXT = "text";
    private static final String IMAGE = "image";


    public static SlideItem createSlideItemWithItemAndType(String type, int level, Element item) {
        if (TEXT.equals(type)) {
            String emptyString = "";
            String text = (!emptyString.equals(item.getTextContent())) ? item.getTextContent() : ErrorMessage.EMPTYTEXT;
            return new TextItem(level, text);
        } else {
            if (IMAGE.equals(type)) {
                return new BitmapItem(level, item.getTextContent());
            } else {
                System.err.println(ErrorMessage.UNKNOWNTYPE);
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