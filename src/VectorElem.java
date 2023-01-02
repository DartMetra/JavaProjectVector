import java.awt.Dimension;
import javax.swing.JLabel;


public class VectorElem extends JLabel {
    public VectorElem(int index) {
        super();
        this.setText(HtmlHelper.emptyVectorElem(index));

        this.setMinimumSize(new Dimension(30, 30));
        this.setMaximumSize(new Dimension(30, 30));
    }

    public VectorElem(String text, int index) {
        super();

        this.setText(HtmlHelper.vectorElem(text, index));
        this.setMinimumSize(new Dimension(30, 30));
        this.setMaximumSize(new Dimension(30, 30));
    }
}
