import GuiComponents.DefaultButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
  static JTextField t;
  static JLabel l;


  static void main() {
    JFrame frame = new JFrame();

    JPanel panel = new JPanel();


    // create a label to display text
    l = new JLabel("nothing entered");
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(10, 10));

    frame.add(panel, BorderLayout.AFTER_LAST_LINE);
    frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
    frame.setTitle("New GUI");
    String text = "";
    JButton dbutton = new DefaultButton("CLICK", 0, 0, 20, 20);
    dbutton.addActionListener(new GUI());
    t = new JTextField(16);
    frame.add(l);
    frame.add(t);

    frame.add(dbutton);


    frame.add(new DefaultButton("2", 30, 30, 20, 20));
    frame.add(new DefaultButton("3", 60, 60, 20, 20));
    frame.add(new DefaultButton("4", 0, 0, 20, 20));
    frame.add(new DefaultButton("5", 0, 0, 20, 20));
    frame.pack();
    frame.setVisible(true);
  }

  public GUI() {

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String s = e.getActionCommand();

    l.setText(t.getText());
    System.out.println(t.getText());
    t.setText("123");

  }
}
