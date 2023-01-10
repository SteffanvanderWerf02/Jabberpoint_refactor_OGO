import Utility.ButtonNames;
import Utility.ErrorMessage;
import Utility.Utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * <p>The controller for the menu</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {

    private Frame parent; //The frame, only used as parent for the Dialogs
    private Presentation presentation; //Commands are given to the presentation


    public MenuController(Frame frame, Presentation pres) {
        parent = frame;
        presentation = pres;
        MenuItem menuItem;
        Menu fileMenu = new Menu(ButtonNames.FILE);
        fileMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.OPEN));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.getSlideController().clear();
                Reader reader = AccessorFactory.getReader(Utility.TESTFILE);
                try {
                    reader.loadFile(presentation, Utility.TESTFILE);
                    presentation.getSlideController().setSlideNumber(0);
                    presentation.updateSlideView();
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(parent, ErrorMessage.IOEX + exc,
                            ErrorMessage.LOADERR, JOptionPane.ERROR_MESSAGE);
                }
                parent.repaint();
            }
        });
        fileMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.NEW));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.getSlideController().clear();
                parent.repaint();
            }
        });
        fileMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.SAVE));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Writer writer = AccessorFactory.getWriter(Utility.SAVEFILE);
                try {
                    writer.saveFile(presentation, Utility.SAVEFILE);
                    presentation.updateSlideView();
                } catch (IOException exc) {
                    JOptionPane.showMessageDialog(parent, ErrorMessage.IOEX + exc,
                            ErrorMessage.SAVEERR, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        fileMenu.addSeparator();
        fileMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.EXIT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.exit(0);
            }
        });
        add(fileMenu);
        Menu viewMenu = new Menu(ButtonNames.VIEW);
        viewMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.NEXT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.getSlideController().nextSlide();
                presentation.updateSlideView();
            }
        });
        viewMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.PREV));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                presentation.getSlideController().prevSlide();
                presentation.updateSlideView();
            }
        });
        viewMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.GOTO));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String pageNumberStr = JOptionPane.showInputDialog((Object) ButtonNames.PAGENR);
                int pageNumber = Integer.parseInt(pageNumberStr);
                presentation.getSlideController().setSlideNumber(pageNumber - 1);
                presentation.updateSlideView();
            }
        });
        add(viewMenu);
        Menu helpMenu = new Menu(ButtonNames.HELP);
        helpMenu.add(menuItem = MenuItemFactory.createMenuItem(ButtonNames.ABOUT));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AboutBox.show(parent);
            }
        });
        setHelpMenu(helpMenu);        //Needed for portability (Motif, etc.).
    }
}