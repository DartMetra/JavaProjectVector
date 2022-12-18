package components;
import javax.swing.JTextField;
import java.awt.*;


public class InputField extends JTextField  {
    public InputField() {
        super();
        this.setFont(new Font(ProjectUtils.fontName, Font.PLAIN, 14));
        this.setMinimumSize(new Dimension(150, 30));
    }
}
