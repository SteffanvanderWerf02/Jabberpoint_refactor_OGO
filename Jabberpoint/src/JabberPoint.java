import Utility.ErrorMessage;

import javax.swing.*;
import java.io.IOException;

/**
 * JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class JabberPoint {
    /**
     * The main program
     */
    public static void main(String[] argv) {
        StyleFactory.createStyles();
        Presentation presentation = PresentationFactory.createPresentation();
        try {
            Reader reader = AccessorFactory.getReaderWithArgs(argv);

            if (argv.length == 0) { //a demo presentation
                reader.loadFile(presentation, "");
            } else {
                reader.loadFile(presentation, argv[0]);
            }

            presentation.updateSlideView();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    ErrorMessage.IOERR + ex, ErrorMessage.JABERR,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}