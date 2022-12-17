package components;
import javax.swing.JLabel;


public class TitleLabel extends JLabel {
    public TitleLabel(String text) {
        super(text);
        this.setFont(Constants.titleFont);
    }
}