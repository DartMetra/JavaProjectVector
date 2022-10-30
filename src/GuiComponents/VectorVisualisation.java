package GuiComponents;

import javax.swing.*;
import java.util.Vector;

public class VectorVisualisation extends JTextArea {
  public VectorVisualisation(){

  }
  public void visualize(Vector<String> vector){
    this.setText(null);
    for (String elem : vector
    ) {
      this.append(elem);
      this.append("\n");
    }
  }
}
