import javax.swing.*;
import java.awt.*;


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