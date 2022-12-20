import javax.swing.JComboBox;
import java.awt.Font;


public class DropList<E> extends JComboBox<E> {
    public DropList(E[] items) {
        super(items);
        this.setFont(new Font(Settings.fontName, Font.PLAIN, 14));
    }
}
