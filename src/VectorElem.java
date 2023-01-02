import java.awt.Dimension;
import javax.swing.JLabel;


public class VectorElem extends JLabel {
    private final Dimension size = new Dimension(100, 100);

    public VectorElem(int index) {
        super();

        this.setText(HtmlHelper.emptyVectorElem(index));
        this.setMaximumSize(size);
        this.setMaximumSize(size);
        this.setPreferredSize(size);
    }

    public VectorElem(String text, int index) {
        super();

        this.setText(HtmlHelper.vectorElem(text, index));
        this.setMaximumSize(size);
        this.setMaximumSize(size);
        this.setPreferredSize(size);
    }
}
