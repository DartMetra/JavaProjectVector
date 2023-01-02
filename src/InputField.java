import javax.swing.JTextField;
import java.awt.*;

/**
 * A unified InputField class, which is extending a JTextField class from java.swing.
 */
public class InputField extends JTextField  {
    public InputField() {
        super();
        this.setFont(new Font(Settings.fontName, Font.PLAIN, 14));
        this.setMinimumSize(new Dimension(150, 30));
    }
}
