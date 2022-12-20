import java.awt.Dimension;
import javax.swing.JLabel;


public class VectorElem extends JLabel {
    public VectorElem(String text) {
        super();

        if (text.length() == 0)
            this.setText(HtmlHelper.emptyVectorElem());
        else
            this.setText(HtmlHelper.vectorElem(text));

        this.setMinimumSize(new Dimension(30, 30));
        this.setMaximumSize(new Dimension(30, 30));
    }
}
