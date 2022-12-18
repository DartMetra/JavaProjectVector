package components;
import javax.swing.JButton;
import java.awt.*;


public class Btn extends JButton  {
    public Btn(String text) {
        super(text);
        this.setFont(new Font(ProjectUtils.fontName, Font.PLAIN, 14));
        this.setMinimumSize(new Dimension(50, 40));
    }
}