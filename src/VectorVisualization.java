import components.*;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorVisualization extends JFrame {
    private Vector vector;

    //testing
    public VectorVisualization() {
        super();

        JPanel gVectors = new JPanel();
        gVectors.setLayout(new FlowLayout(FlowLayout.LEFT));
        gVectors.setBackground(Color.green);

        gVectors.add(new VectorBox(ProjectUtils.vectorElement("1")));
        gVectors.add(new VectorBox(ProjectUtils.vectorElement("1")));

        JPanel editPanel = new JPanel();
        editPanel.setLayout(new GridBagLayout());


        Btn addElem = new Btn("Додати елемент");
        Btn remElem = new Btn("Видалити елемент");
        Btn clear = new Btn("Очистити");
        Btn increaseCap = new Btn("Збільшити ємність");
        Btn decreaseCap = new Btn("Зменшити ємність");

        GridPosition pos = new GridPosition();

        editPanel.add(addElem, pos.nextRow().setInsets(20));
        editPanel.add(remElem, pos.nextRow());
        editPanel.add(clear, pos.nextRow());
        editPanel.add(increaseCap, pos.nextRow());
        editPanel.add(decreaseCap, pos.nextRow());
        editPanel.setBackground(Color.red);


        this.setTitle("Вектор GUI");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1200, 1000));

        this.add(gVectors, BorderLayout.CENTER);


        this.add(editPanel, BorderLayout.LINE_END);


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
