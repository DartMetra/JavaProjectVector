package GuiComponents;

import javax.swing.JButton;
import java.awt.*;

public class DefaultButton extends JButton {
  public DefaultButton(String text, int x, int y, int width, int height) {

    this.setText(text);
    this.setBounds(x, y, width, height);
    this.setSize(300, 300);
    this.setForeground(Color.CYAN);
  }


}
