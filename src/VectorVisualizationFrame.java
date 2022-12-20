import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


public class VectorVisualizationFrame<Type> extends JFrame implements ActionListener {
    private Vector<Type> vector;

    private JPanel vectorPanel = new JPanel(new GridBagLayout());
    private GridPosition vectorElemPos = new GridPosition().setInsets(5);

    public VectorVisualizationFrame(int initialCapacity,int capacityIncrement) {
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
        // add() Додати
        // remove() Видалити
        // insertElementAt() Вставити
        // set() Замінити
        // setSize() Встановити розмір
        // clear() Очистити
        // tripToSize() Обрізати
        // removeRange() ? Видалити частину вектора????

        GridPosition position = new GridPosition().setPosition(0, 0).setInsets(15, 5, 15, 5);
        JPanel controlPanel = new JPanel(new GridBagLayout());
        Btn addBtn = new Btn(HtmlHelper.plain("Додати елемент"), new ImageIcon("images/add.png"));
        Btn removeBtn = new Btn(HtmlHelper.plain("Видалити елемент"), new ImageIcon("images/remove.png"));
        Btn insertBtn = new Btn(HtmlHelper.plain("Вставити елемент"), new ImageIcon("images/insert.png"));
        Btn setBtn = new Btn(HtmlHelper.plain("Замінити елемент"), new ImageIcon("images/set.png"));
        Btn setSizeBtn = new Btn(HtmlHelper.plain("Встановити розмір вектора"), new ImageIcon("images/setSize.png"));
        Btn clearBtn = new Btn(HtmlHelper.plain("Очистити вектор"), new ImageIcon("images/clear.png"));
        Btn trimToSizeBtn = new Btn(HtmlHelper.plain("Обрізати до розміру"), new ImageIcon("images/trimToSize.png"));



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

    public void actionPerformed(ActionEvent event) {}
}
