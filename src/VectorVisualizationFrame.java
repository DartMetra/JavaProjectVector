import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualizationFrame extends JFrame implements ActionListener {
    private final Vector vector;

    private final JPanel vectorPanel = new JPanel(new GridBagLayout());
    private final GridPosition vectorElemPos = new GridPosition().setInsets(5);

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

        switch (elemType) {
            case STRING -> this.vector = new Vector<String>(initialCapacity, capacityIncrement);
            case INT -> this.vector = new Vector<Integer>(initialCapacity, capacityIncrement);
            case DOUBLE -> this.vector = new Vector<Double>(initialCapacity, capacityIncrement);
            default -> this.vector = new Vector<String>(initialCapacity, capacityIncrement);
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

        GridPosition position = new GridPosition().setPosition(0, 0).setInsets(15, 5, 15, 5);
        JPanel controlPanel = new JPanel(new GridBagLayout());
        Btn addBtn = new Btn(HtmlHelper.plain("Додати елемент"), new ImageIcon("images/add.png"));
        addBtn.addActionListener(this);
        addBtn.setActionCommand(addElemCmd);

        Btn removeBtn = new Btn(HtmlHelper.plain("Видалити елемент"), new ImageIcon("images/remove.png"));
        removeBtn.addActionListener(this);
        removeBtn.setActionCommand(remElemCmd);

        Btn insertBtn = new Btn(HtmlHelper.plain("Вставити елемент"), new ImageIcon("images/insert.png"));
        insertBtn.addActionListener(this);
        insertBtn.setActionCommand(insertElemCmd);

        Btn setBtn = new Btn(HtmlHelper.plain("Замінити елемент"), new ImageIcon("images/set.png"));
        setBtn.addActionListener(this);
        setBtn.setActionCommand(setElemCmd);

        Btn setSizeBtn = new Btn(HtmlHelper.plain("Встановити розмір вектора"), new ImageIcon("images/setSize.png"));
        setSizeBtn.addActionListener(this);
        setSizeBtn.setActionCommand(setSizeCmd);

        Btn clearBtn = new Btn(HtmlHelper.plain("Очистити вектор"), new ImageIcon("images/clear.png"));
        clearBtn.addActionListener(this);
        clearBtn.setActionCommand(clearVectorCmd);

        Btn trimToSizeBtn = new Btn(HtmlHelper.plain("Обрізати до розміру"), new ImageIcon("images/trimToSize.png"));
        trimToSizeBtn.addActionListener(this);
        trimToSizeBtn.setActionCommand(trimToSizeCmd);


        position.fill = GridPosition.BOTH;
        controlPanel.setBackground(new Color(220, 220, 225));
        controlPanel.add(addBtn, position);
        controlPanel.add(removeBtn, position.nextRow());
        controlPanel.add(insertBtn, position.nextRow());
        controlPanel.add(setBtn, position.nextRow());
        controlPanel.add(setSizeBtn, position.nextRow());
        controlPanel.add(clearBtn, position.nextRow());
        controlPanel.add(trimToSizeBtn, position.nextRow());

        vectorPanel.setBackground(Color.GRAY);
        this.renderVector();
        JScrollPane scrollPane = new JScrollPane(vectorPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.setLayout(new BorderLayout());
        // this.add(vectorPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.EAST);

        JPanel centerPanel = new JPanel(new GridLayout(3, 1));
        centerPanel.add(new JPanel());
        centerPanel.add(new JPanel());
        centerPanel.add(scrollPane);

        this.add(scrollPane, BorderLayout.NORTH);
    }

    private void renderVector() {
        vectorPanel.removeAll();

        for (Object elem : vector)
            vectorPanel.add(new VectorElem(elem.toString()));

        for (int i = 0; i < vector.capacity() - vector.size(); i++)
            vectorPanel.add(new VectorElem("."));


        vectorPanel.repaint();

    }

    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();

        switch (cmd) {

            case addElemCmd -> {

                /// add an element to a vector
                String elem = JOptionPane.showInputDialog(this, "Введіть елемент", "Додати елемент", JOptionPane.QUESTION_MESSAGE);
                if (elem != null) {

                    vector.add(elem);
                    this.renderVector();
                }

            }
            case remElemCmd -> {
                //ask user for an index
                //remove an element from a vector
                String s = JOptionPane.showInputDialog("Enter vector index");
                int index = Integer.parseInt(s);
                vector.remove(index);
                this.renderVector();
            }

            case insertElemCmd -> {
                System.out.println("insert");
                /// inserts an element at some place into a vector
            }
            case setElemCmd -> {
                System.out.println("replace");
                /// replacing an element in a vector
            }
            case setSizeCmd -> {
                System.out.println("set");
                /// setting the size of a vector
            }
            case clearVectorCmd -> {
                System.out.println("clear");
                /// clears a vector
            }
            case trimToSizeCmd -> {
                System.out.println("trim");
                /// trims to size a vector
            }
        }
    }
}
