import Utility.DefaultFont;
import Utility.SlideSize;

import javax.swing.*;
import java.awt.*;


/**
 * <p>SlideViewerComponent is a graphical component that ca display Slides.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent {

    private Slide slide; //The current slide
    private Font labelFont; //The font for labels
    private Presentation presentation; //The presentation
    private JFrame frame;
    private static final long serialVersionUID = 227L;

    public SlideViewerComponent(Presentation pres, JFrame frame) {
        setBackground(DefaultFont.BGCOLOR);
        presentation = pres;
        labelFont = FontFactory.createFont(DefaultFont.FONTNAME, DefaultFont.FONTSTYLE, DefaultFont.FONTHEIGHT);
        this.frame = frame;
    }

    public Dimension getPreferredSize() {
        return new Dimension(SlideSize.WIDTH, SlideSize.HEIGHT);
    }

    public void update(Presentation presentation, Slide data) {
        if (data == null) {
            repaint();
            return;
        }
        this.presentation = presentation;
        this.slide = data;
        repaint();
        frame.setTitle(presentation.getTitle());
    }

    //Draw the slide
    public void paintComponent(Graphics g) {
        g.setColor(DefaultFont.BGCOLOR);
        g.fillRect(0, 0, getSize().width, getSize().height);
        if (presentation.getSlideController().getSlideNumber() < 0 || slide == null) {
            return;
        }
        g.setFont(labelFont);
        g.setColor(DefaultFont.COLOR);
        g.drawString("Slide " + (1 + presentation.getSlideController().getSlideNumber()) + " of " +
                presentation.getSlideController().getSize(), DefaultFont.XPOS, DefaultFont.YPOS);
        Rectangle area = new Rectangle(0, DefaultFont.YPOS, getWidth(), (getHeight() - DefaultFont.YPOS));
        slide.draw(g, area, this);
    }
}