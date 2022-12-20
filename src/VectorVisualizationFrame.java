import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualizationFrame<Type> extends JFrame implements ActionListener {
    private Vector<Type> vector;

    private JPanel vectorPanel = new JPanel(new GridBagLayout());
    private GridPosition vectorElemPos = new GridPosition().setInsets(5);

    private final String addElemCmd = "addElem";
    private String remElemCmd = "remElem";
    private String InsertElemCmd = "insertElem";
    private String setElemCmd = "remElem";
    private String setSizeCmd = "addElem";
    private String clearVectorCmd = "addElem";
    private String trimToSizeCmd = "addElem";


    public VectorVisualizationFrame(int initialCapacity, int capacityIncrement) {
        super();

        this.vector = new Vector<Type>(initialCapacity, capacityIncrement);

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
        removeBtn.setActionCommand("removeElem");

        Btn insertBtn = new Btn(HtmlHelper.plain("Вставити елемент"), new ImageIcon("images/insert.png"));
        insertBtn.addActionListener(this);
        insertBtn.setActionCommand("insertElem");

        Btn setBtn = new Btn(HtmlHelper.plain("Замінити елемент"), new ImageIcon("images/set.png"));
        setBtn.addActionListener(this);
        setBtn.setActionCommand("setElem");

        Btn setSizeBtn = new Btn(HtmlHelper.plain("Встановити розмір вектора"), new ImageIcon("images/setSize.png"));
        setSizeBtn.addActionListener(this);
        setSizeBtn.setActionCommand("setSize");

        Btn clearBtn = new Btn(HtmlHelper.plain("Очистити вектор"), new ImageIcon("images/clear.png"));
        clearBtn.addActionListener(this);
        clearBtn.setActionCommand("clear");

        Btn trimToSizeBtn = new Btn(HtmlHelper.plain("Обрізати до розміру"), new ImageIcon("images/trimToSize.png"));
        trimToSizeBtn.addActionListener(this);
        trimToSizeBtn.setActionCommand("trimToSize");


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
        for (Type elem : vector)
            vectorPanel.add(new VectorElem(elem.toString()));

        for (int i = 0; i < vector.capacity() - vector.size(); i++)
            vectorPanel.add(new VectorElem("."));
    }

    private void renderAddElement(Type element) {
        vector.add(element);
        renderVector();
    }

    private void renderRemElement(int index) {
        vector.remove(index);
        renderVector();
    }

    private void renderInsertElement(Type obj, int index) {
        vector.insertElementAt(obj, index);
        renderVector();
    }

    private void renderSetElement(Type obj, int index) {
        vector.set(index, obj);
        renderVector();
    }

    private void renderSetSizeVector(int newSize) {
        vector.setSize(newSize);
        renderVector();
    }

    private void renderClearVector() {
        vector.removeAllElements();
        renderVector();
    }

    private void renderTrimToSizeVector() {
        vector.trimToSize();
        renderVector();
    }

    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();

        switch (cmd) {

            case addElemCmd -> {
                System.out.println("add");
            }
            case "removeElem" -> {
                System.out.println("rem");
                /// remove an element from a vector
            }
            case "insertElem" -> {
                System.out.println("insert");
                /// inserts an element at some place into a vector
            }
            case "setElem" -> {
                System.out.println("replace");
                /// replacing an element in a vector
            }
            case "setSize" -> {
                System.out.println("set");
                /// setting the size of a vector
            }
            case "clear" -> {
                System.out.println("clear");
                /// clears a vector
            }
            case "trimToSize" -> {
                System.out.println("trim");
                /// trims to size a vector
            }
        }
    }
}
