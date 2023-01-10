import java.awt.*;

public class MenuItemFactory {
    //Creating a menu-item
    public static MenuItem createMenuItem(String name) {
        return new MenuItem(name, new MenuShortcut(name.charAt(0)));
    }
}