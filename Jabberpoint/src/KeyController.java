import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * <p>This is the KeyController (KeyListener)</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class KeyController extends KeyAdapter {
    private Presentation presentation; //Commands are given to the presentation

    public KeyController(Presentation p) {
        presentation = p;
    }

    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_PAGE_DOWN:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_ENTER:
            case '+':
                presentation.getSlideController().nextSlide();
                presentation.updateSlideView();
                break;
            case KeyEvent.VK_PAGE_UP:
            case KeyEvent.VK_UP:
            case '-':
                presentation.getSlideController().prevSlide();
                presentation.updateSlideView();
                break;
            case 'q':
            case 'Q':
                presentation.exit(0);
                break; //Should not be reached
            default:
                break;
        }
    }
}