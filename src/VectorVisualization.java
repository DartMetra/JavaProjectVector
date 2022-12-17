import components.*;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualization extends JFrame {
    private Vector vector;

    public VectorVisualization(){
        super();

        JPanel gVectors = new JPanel();
        gVectors.setLayout(new FlowLayout(FlowLayout.LEFT,1,20));
        gVectors.add(new VectorBox());
        gVectors.add(new VectorBox());



        this.setTitle("Вектор GUI");
        this.setPreferredSize(new Dimension(1200, 1000));
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,2,20,20));

        this.add(gVectors);
        this.add(gVectors);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
