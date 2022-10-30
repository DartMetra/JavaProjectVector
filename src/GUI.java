
import GuiComponents.VectorVisualisation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class GUI extends JComponent implements ActionListener {
  private Vector<String> vector;
  private JTextField input;
  private VectorVisualisation vectorTextArea;
  private JFrame frame;
  private JButton addButton;

  public GUI() {
    this.frame = new JFrame("Vector Editor");
    this.vectorTextArea = new VectorVisualisation();
    this.vector = new Vector<>();
    this.addButton = new JButton("Add element");
    this.input = new JTextField(10);

    this.addButton.setActionCommand("AddElem");
    this.addButton.addActionListener(this);

    this.vector.add("123");
    this.vector.add("456");
    this.vector.add("789");
    this.vector.add("102");

    this.vectorTextArea.visualize(this.vector);
  }

  public void render() {
    this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.frame.setLayout(new FlowLayout());

    this.frame.add(this.vectorTextArea);
    this.frame.add(this.addButton);
    this.frame.add(this.input);

    this.frame.pack();
    this.frame.setVisible(true);
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(500, 500);

  }


  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();

    this.vector.add(this.input.getText());
    this.input.setText("");
    this.vectorTextArea.visualize(this.vector);


    for (String elem : this.vector
    ) {
      System.out.println(elem);
    }
  }

}