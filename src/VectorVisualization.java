import java.awt.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualization extends JFrame {
    private Vector vector;

    public VectorVisualization() {
        super();

        InitFrame initFrame = new InitFrame();


        this.setTitle("Візуалізація вектора");
        this.setMinimumSize(new Dimension(400, 700));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.pack();
        this.setLocationRelativeTo(null);

    }
}
