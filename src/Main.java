
import GuiComponents.VectorVisualisation;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Main {

  public static void main(String[] args) {

    //Creating the Frame
    JFrame frame = new JFrame("Chat Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);


    Vector<String> vector = new Vector<>();
    vector.add("123");
    vector.add("456");
    vector.add("789");
    vector.add("102");

    //Creating the MenuBar and adding components

    //Creating the panel at bottom and adding components
    JPanel panel = new JPanel(); // the panel is not visible in output



    // Text Area at the Center
    VectorVisualisation vectorText = new VectorVisualisation();
    vectorText.visualize(vector);vectorText.visualize(vector);vectorText.visualize(vector);
    //Adding Components to the frame.
    frame.getContentPane().add(BorderLayout.SOUTH, panel);
    frame.getContentPane().add(BorderLayout.CENTER, vectorText);
    frame.setVisible(true);
  }
}