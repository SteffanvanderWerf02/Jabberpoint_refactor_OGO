import Utility.SlideSize;
import Utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>The applicatiewindow for a slideviewcomponent</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerFrame extends JFrame {
    private static final long serialVersionUID = 3227L;

    public SlideViewerFrame(String title, Presentation presentation) {
        super(title);
        SlideViewerComponent slideViewerComponent = SlideViewerComponentFactory.createSlideViewerComponent(presentation, this);
        PresentationFactory.addSlideViewerComponent(presentation, slideViewerComponent);

        //setup GUI
        setupWindow(presentation);
    }

    //Setup the GUI
    public void setupWindow(Presentation presentation) {
        setTitle(Utility.JABTITLE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(presentation.getSlideViewerComponent());
        addKeyListener(new KeyController(presentation)); //Add a controller
        setMenuBar(new MenuController(this, presentation));    //Add another controller
        setSize(new Dimension(SlideSize.WIDTH, SlideSize.HEIGHT)); //Same sizes a slide has
        setVisible(true);
    }
}