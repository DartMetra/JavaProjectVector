import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.Font;

/**
 * A unified Button class, which is extending a JButton class from java.swing.
 */
public class Btn extends JButton  {
    public Btn(String text) {
        super(text);
        this.setFont(new Font(Settings.fontName, Font.PLAIN, 14));
    }

    public Btn(String text, Icon icon) {
        super(text, icon);
        this.setFont(new Font(Settings.fontName, Font.PLAIN, 14));
    }
}