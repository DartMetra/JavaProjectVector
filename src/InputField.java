import javax.swing.JTextField;
import java.awt.*;


public class InputField extends JTextField  {
    public InputField() {
        super();
        this.setFont(new Font(Settings.fontName, Font.PLAIN, 14));
        this.setMinimumSize(new Dimension(150, 30));
    }
}
