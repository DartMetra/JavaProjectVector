import javax.swing.JComboBox;
import java.awt.Font;

/**
 * A unified DropList class, which is extending a JCombo-Box class from java.swing.
 */
public class DropList<E> extends JComboBox<E> {
    public DropList(E[] items) {
        super(items);
        this.setFont(new Font(Settings.fontName, Font.PLAIN, 14));
    }
}
