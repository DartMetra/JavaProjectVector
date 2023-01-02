import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualizationFrame extends JFrame implements ActionListener {
    private Vector<String> vector = new Vector<>();
    private final ElemType elemType;

    private final JPanel vectorPanel = new JPanel(new GridBagLayout());
    private final JLabel sizeLabel = new JLabel();
    private final JLabel capacityLabel = new JLabel();

    private final String addElemCmd = "addElement";
    private final String remElemCmd = "removeElement";
    private final String insertElemCmd = "insertElement";
    private final String setElemCmd = "setElement";
    private final String setSizeCmd = "setSize";
    private final String clearVectorCmd = "clearVector";
    private final String trimToSizeCmd = "trimToSize";

    public VectorVisualizationFrame(int initialCapacity, int capacityIncrement,
                                    ElemType elemType) {
        super();

        this.elemType = elemType;
        this.setTitle(Settings.programName);
        this.setIconImage(new ImageIcon("images/icon.png").getImage());
        this.setMinimumSize(new Dimension(800, 500));
        this.setPreferredSize(new Dimension(800, 500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.render();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void render() {
        JLabel typeLabel = new JLabel(HtmlHelper.title("Тип елементів: " + elemType.name));

        Btn addBtn = new Btn(
            HtmlHelper.plain("Додати елемент"),
            new ImageIcon("images/add.png")
        );
        addBtn.setActionCommand(addElemCmd);
        addBtn.addActionListener(this);

        Btn removeBtn = new Btn(
            HtmlHelper.plain("Видалити елемент"),
            new ImageIcon("images/remove.png")
        );
        removeBtn.setActionCommand(remElemCmd);
        removeBtn.addActionListener(this);

        Btn insertBtn = new Btn(
            HtmlHelper.plain("Вставити елемент"),
            new ImageIcon("images/insert.png")
        );
        insertBtn.setActionCommand(insertElemCmd);
        insertBtn.addActionListener(this);

        Btn setBtn = new Btn(
            HtmlHelper.plain("Замінити елемент"),
            new ImageIcon("images/set.png")
        );
        setBtn.setActionCommand(setElemCmd);
        setBtn.addActionListener(this);

        Btn setSizeBtn = new Btn(
            HtmlHelper.plain("Встановити розмір вектора"),
            new ImageIcon("images/setSize.png")
        );
        setSizeBtn.setActionCommand(setSizeCmd);
        setSizeBtn.addActionListener(this);

        Btn clearBtn = new Btn(
            HtmlHelper.plain("Очистити вектор"),
            new ImageIcon("images/clear.png")
        );
        clearBtn.setActionCommand(clearVectorCmd);
        clearBtn.addActionListener(this);

        Btn trimToSizeBtn = new Btn(
            HtmlHelper.plain("Обрізати до розміру"),
            new ImageIcon("images/trimToSize.png")
        );
        trimToSizeBtn.setActionCommand(trimToSizeCmd);
        trimToSizeBtn.addActionListener(this);

        GridPosition position = new GridPosition()
            .setPosition(0, 0)
            .setInsets(15, 5, 15, 5);
        position.fill = GridPosition.BOTH;

        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBackground(new Color(220, 220, 225));
        controlPanel.add(addBtn, position);
        controlPanel.add(removeBtn, position.nextRow());
        controlPanel.add(insertBtn, position.nextRow());
        controlPanel.add(setBtn, position.nextRow());
        controlPanel.add(setSizeBtn, position.nextRow());
        controlPanel.add(clearBtn, position.nextRow());
        controlPanel.add(trimToSizeBtn, position.nextRow());

        vectorPanel.setBackground(new Color(255, 255, 255));
        JScrollPane scrollPane = new JScrollPane(vectorPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        this.renderVector();

        this.setLayout(new BorderLayout());
        this.add(controlPanel, BorderLayout.EAST);
        this.add(scrollPane, BorderLayout.NORTH);
        this.add(typeLabel, BorderLayout.CENTER);
        this.add(sizeLabel, BorderLayout.CENTER);
        this.add(capacityLabel, BorderLayout.CENTER);
    }

    private void renderVector() {
        sizeLabel.setText(HtmlHelper.title("Місткість: " + vector.size()));
        capacityLabel.setText(HtmlHelper.title("Розмір: " + vector.capacity()));

        vectorPanel.removeAll();
        vectorPanel.add(new JLabel(HtmlHelper.emptyBlock()));

        for (int i = 0; i < vector.capacity(); i++) {
            try {
                vectorPanel.add(new JLabel(HtmlHelper.vectorElem(vector.get(i).toString(), i)));
            } catch (ArrayIndexOutOfBoundsException e) {
                vectorPanel.add(new JLabel(HtmlHelper.vectorElem(i)));
            }
        }

        vectorPanel.add(new JLabel(HtmlHelper.emptyBlock()));

        vectorPanel.updateUI();
        sizeLabel.updateUI();
        capacityLabel.updateUI();
    }



  public void actionPerformed(ActionEvent event) {
    switch (event.getActionCommand()) {
      case addElemCmd -> {
        this.handleAddElem();
      }
      case remElemCmd -> {
        this.handleRemElem();
      }
      case insertElemCmd -> {
        this.handleInsertElem();
      }
      case setElemCmd -> {
        this.handleSetElem();
      }
      case setSizeCmd -> {
        this.handleSetSize();

      }
      case clearVectorCmd -> {
        this.handleClearVector();

      }
      case trimToSizeCmd -> {
        this.handleTrimToSize();
      }
    }
  }

  private void handleAddElem() {
    String elem = JOptionPane.showInputDialog(this, "Введіть елемент", "Додати елемент", JOptionPane.QUESTION_MESSAGE);
    if (elem != null && ValidateByType.validate(elem, this.elemType)) {
      System.out.println(elem);
      vector.add(elem);
      this.renderVector();
    }
    else {
      JOptionPane.showMessageDialog(this, "Невірний тип елементу", "Помилка", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void handleRemElem() {
    // ask user for index to remove vector element
    String index = JOptionPane.showInputDialog(this, "Введіть індекс", "Видалити елемент", JOptionPane.QUESTION_MESSAGE);
    if (index != null) {
      try {
        int idx = Integer.parseInt(index);
        vector.remove(idx);
        this.renderVector();
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Невірний індекс", "Помилка", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void handleInsertElem() {
    // ask user for index to insert vector element
    String[] results = MultipleInput.render("Введіть індекс", "Введіть елемент", "Замінити елемент");
    // insert element to vector and validate using ValidateByType class

    if (results == null) {
      throw new NullPointerException("results is null");
    }
    if (results[0] == null || !ValidateByType.validate(results[0], ElemType.INT)) {
      System.out.println(results[0]);
      System.out.println(this.elemType);
      JOptionPane.showMessageDialog(this, "Невірний індекс", "Помилка", JOptionPane.ERROR_MESSAGE);
      return;
    }

    if (results[1] == null || !ValidateByType.validate(results[1], this.elemType)) {
      JOptionPane.showMessageDialog(this, "Невірний елемент", "Помилка", JOptionPane.ERROR_MESSAGE);
      return;
    }
    System.out.println("inserting");

    switch (this.elemType) {
      case INT -> {
        vector.insertElementAt( Integer.parseInt(results[1]),Integer.parseInt(results[0]));
      }
      case DOUBLE -> {
        vector.insertElementAt(Double.parseDouble(results[1]), Integer.parseInt(results[0]));
      }
      case STRING -> {
        vector.insertElementAt(results[1], Integer.parseInt(results[0]));
      }
    }

    this.renderVector();

  }

  private void handleSetElem() {
    // ask user for index to set vector element
    String[] results = MultipleInput.render("Введіть індекс", "Введіть елемент", "Замінити елемент");
    try {
      if (results != null) {
        for (String result : results) {
          if (result.isEmpty())
            break;
        }
        vector.set(Integer.parseInt(results[0]), results[1]);
      }
      this.renderVector();
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Невірний індекс", "Помилка", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void handleSetSize() {
    // ask user for new vector size
    String size = JOptionPane.showInputDialog(this, "Введіть розмір", "Встановити розмір", JOptionPane.QUESTION_MESSAGE);
    System.out.println(size);
    if (size != null ) {
      try {
        int newSize = Integer.parseInt(size);
        System.out.println(size);
        System.out.println( "parsed");
        vector.setSize(newSize);
        System.out.println("set");
        this.renderVector();
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Невірний розмір", "Помилка", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  private void handleClearVector() {
    // ask user for confirmation
    int result = JOptionPane.showConfirmDialog(this, "Ви впевнені?", "Очистити вектор", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      vector.clear();
      this.renderVector();
    }
  }

  private void handleTrimToSize() {
    //ask user for confirmation
    int result = JOptionPane.showConfirmDialog(this, "Ви впевнені?", "Відсікти непотрібні елементи", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
      vector.trimToSize();
      this.renderVector();
    }
  }
}
