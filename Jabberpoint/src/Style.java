import java.awt.*;

/**
 * <p>Style stands for Indent, Color, Font and Leading.</p>
 * <p>The link between a style number and a item level is hard-linked:
 * in Slide the style is grabbed for an item
 * with a style number the same as the item level.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Style {


    private static final String FONTNAME = "Helvetica";
    int indent;
    Color color;
    Font font;
    int fontSize;
    int leading;

    public static Style getStyle(int level) {
        if (level >= StyleFactory.styles.length) {
            level = StyleFactory.styles.length - 1;
        }
        return StyleFactory.styles[level];
    }

    public Style(int indent, Color color, int points, int leading) {
        this.indent = indent;
        this.color = color;
        font = new Font(FONTNAME, Font.BOLD, fontSize = points);
        this.leading = leading;
    }

    public String toString() {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }
}