import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualizationFrame extends JFrame implements ActionListener {
    private Vector vector;
    private final ElemType elemType;
    private final JPanel vectorPanel = new JPanel(new GridBagLayout());

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
    switch (this.elemType) {
      case STRING -> this.vector = new Vector<String>(initialCapacity, capacityIncrement);
      case INT -> this.vector = new Vector<Integer>(initialCapacity, capacityIncrement);
      case DOUBLE -> this.vector = new Vector<Double>(initialCapacity, capacityIncrement);
      default -> new RuntimeException("Unknown type");
    }

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
        this.renderVector();
        JScrollPane scrollPane = new JScrollPane(vectorPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        this.setLayout(new BorderLayout());
        this.add(controlPanel, BorderLayout.EAST);
        this.add(scrollPane, BorderLayout.NORTH);
    }

    private void renderVector() {
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

    private void handleAddElem(){
        String elem = JOptionPane.showInputDialog(this, "Введіть елемент", "Додати елемент", JOptionPane.QUESTION_MESSAGE);
        if (elem != null ) {
            System.out.println(elem);
            vector.add(elem);
            this.renderVector();
        }
    }

    private void handleRemElem(){
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
    private void  handleInsertElem(){
        // ask user for index to insert vector element
        String[] results = MultipleInput.render("Введіть індекс", "Введіть елемент", "Замінити елемент");
        try {
            if (results != null) {
                for (String result : results) {
                    if (result.isEmpty())
                        break;
                }
                vector.insertElementAt(results[1], Integer.parseInt(results[0]));
            }
            this.renderVector();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Невірний індекс", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void  handleSetElem(){
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
    private  void handleSetSize(){
        // ask user for new vector size
        String size = JOptionPane.showInputDialog(this, "Введіть розмір", "Встановити розмір", JOptionPane.QUESTION_MESSAGE);
        if (size != null) {
            try {
                int newSize = Integer.parseInt(size);
                vector.setSize(newSize);
                this.renderVector();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Невірний розмір", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void handleClearVector(){
        // ask user for confirmation
        int result = JOptionPane.showConfirmDialog(this, "Ви впевнені?", "Очистити вектор", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            vector.clear();
            this.renderVector();
        }
    }

    private  void handleTrimToSize(){
        //ask user for confirmation
        int result = JOptionPane.showConfirmDialog(this, "Ви впевнені?", "Відсікти непотрібні елементи", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            vector.trimToSize();
            this.renderVector();
        }
    }
}
