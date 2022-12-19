package components;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;


public class Label extends JLabel {
    public Label(String text) {
        super(text);
        this.setFont(new Font(ProjectUtils.fontName, Font.PLAIN, 14));
        this.setMinimumSize(new Dimension(50, 40));
    }
}