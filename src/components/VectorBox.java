package components;

import javax.swing.JLabel;
import java.awt.*;

public class VectorBox extends JLabel {

    public VectorBox(String text) {
        super(text);
        this.setFont(new Font(ProjectUtils.fontName, Font.PLAIN, 14));
    }
}
