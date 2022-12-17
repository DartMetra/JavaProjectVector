import components.*;

import java.awt.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualization extends JFrame {
    private Vector vector;

    public VectorVisualization() {
        super();

        JPanel gVectors = new JPanel();
        gVectors.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        gVectors.setBackground(Color.green);
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));
        gVectors.add(new VectorBox("1"));
        gVectors.add(new VectorBox("2"));


        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridLayout(0,1,0,50));
        editPanel.add(new JButton("Додати елемент"));
        editPanel.add(new JButton("Додати1"));
        editPanel.add(new JButton("Додати2"));
        editPanel.add(new JButton("Додати3"));
        editPanel.add(new JButton("Додати4"));
        editPanel.add(new JLabel("Розмір вектора: null"));
        editPanel.add(new JLabel("Ємність вектора: null"));
        editPanel.setBackground(Color.red);

        this.setTitle("Вектор GUI");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.setPreferredSize(new Dimension(1200, 1000));

        c.ipady = 0;

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(60,25,0,100);

        c.weighty = 1.0;

        c.gridx = 0;
        c.gridy = 0;

        this.add(gVectors, c);

        c.anchor = GridBagConstraints.FIRST_LINE_END;

        c.gridheight = 3;


        c.gridx = 2;
        c.gridy = 0;

        this.add(editPanel, c);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
