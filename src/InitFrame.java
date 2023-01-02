import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class InitFrame extends JFrame implements ActionListener {
    private DropList<ElemType> typeInput = new DropList<ElemType>(ElemType.values());
    private InputField initialCapacityField = new InputField();
    private InputField capacityIncrementField = new InputField();

    public InitFrame() {
        super();

        this.setTitle(Settings.programName);
        this.setIconImage(new ImageIcon("images/icon.png").getImage());
        this.setMinimumSize(new Dimension(700, 400));
        this.setPreferredSize(new Dimension(700, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.render();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void render() {
        String welcomeBlock = """
            <div class='welcome-block'>
                <h1>%s</h1>
                <p>Спочатку необхідно встановити початкові налаштування
                   вектора, а саме обрати <b>тип елементів</b>, встановити
                   <b>початкову місткість</b> та <b>інкременту місткості</b>,
                   тобто число на котре буде збільшуватися місткість після
                   переповнення.</p>
            </div>
            """.formatted(Settings.programName);
        JLabel welcomeLabel = new JLabel(HtmlHelper.htmlTag(welcomeBlock));
        JLabel typeLabel = new JLabel(HtmlHelper.plain("Оберіть тип елементів вектора"));
        JLabel initialCapacityLabel = new JLabel(HtmlHelper.plain("Введіть початкову місткість"));
        JLabel capacityIncrementLabel = new JLabel(HtmlHelper.plain("Введіть інкременту місткості"));
        Btn initButton = new Btn("Встановити налаштування");
        GridPosition position = new GridPosition().setPosition(0, 0);

        initButton.setMinimumSize(new Dimension(200, 40));
        initButton.addActionListener(this);
        welcomeLabel.setMinimumSize(new Dimension(300, 250));
        position.fill = GridBagConstraints.HORIZONTAL;

        this.setLayout(new GridBagLayout());
        this.add(welcomeLabel, position.setSize(1, 7));
        this.add(typeLabel, position.setSize(1, 1).nextColumn());
        this.add(typeInput, position.nextRow());
        this.add(initialCapacityLabel, position.nextRow());
        this.add(initialCapacityField, position.nextRow());
        this.add(capacityIncrementLabel, position.nextRow());
        this.add(capacityIncrementField, position.nextRow());
        this.add(initButton, position.nextRow());
    }

    public void actionPerformed(ActionEvent event) {
        ElemType type;
        int initialCapacity;
        int capacityIncrement;

        try {
            type = (ElemType) typeInput.getSelectedItem();
            initialCapacity = Integer.parseInt(initialCapacityField.getText());
            capacityIncrement = Integer.parseInt(capacityIncrementField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Необхідно заповнити поля цілими числами",
                Settings.programName,
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (initialCapacity < 1 || initialCapacity > 50) {
            JOptionPane.showMessageDialog(
                this,
                "Початкова місткість має бути цілим числом від 1 до 50 включно",
                Settings.programName,
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (capacityIncrement < 1 || capacityIncrement > 10) {
            JOptionPane.showMessageDialog(
                this,
                "Інкремента місткості має бути цілим числом від 1 до 10 включно",
                Settings.programName,
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        this.setVisible(false);
        this.dispose();

        new VectorVisualizationFrame(initialCapacity, capacityIncrement, type);
    }
}