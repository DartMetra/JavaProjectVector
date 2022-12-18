import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import components.*;
import java.util.Vector;


public class InitFrame extends JFrame implements ActionListener {
    private ElementsType type;
    private int initialCapacity;
    private int capacityIncrement;

    private InputField initialCapacityField = new InputField();
    private InputField capacityIncrementField = new InputField();


    public InitFrame() {
        super();

        this.setTitle("Візуалізація вектора");
        this.setMinimumSize(new Dimension(700, 400));
        this.setPreferredSize(new Dimension(700, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        JLabel descriptionLabel = new JLabel(ProjectUtils.html("""
            <div class="description">
                <h1>Візуалізація вектора</h1>
                <p>Спочатку необхідно встановити початкові налаштування
                   вектора, а саме обрати <b>тип елементів</b>, встановити
                   <b>початкову місткість</b> та <b>інкременту місткості</b>,
                   тобто число на котре буде збільшуватися місткість після
                   переповнення.</p>
            </div>
            """));
        descriptionLabel.setMinimumSize(new Dimension(300, 220));

        Btn initButton = new Btn("Встановити налаштування");
        initButton.addActionListener(this);
        initButton.setMinimumSize(new Dimension(200, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ProjectUtils.setConstraint(gbc, 0, 0, 1, 7);
        this.add(descriptionLabel, gbc);

        ProjectUtils.setConstraint(gbc, 1, 0);
        this.add(new JLabel(ProjectUtils.paragraph("Введіть початкову місткість")), gbc);

        ProjectUtils.setConstraint(gbc, 1, 1);
        this.add(initialCapacityField, gbc);

        ProjectUtils.setConstraint(gbc, 1, 2);
        this.add(new JLabel(ProjectUtils.paragraph("Введіть інкременту місткості")), gbc);

        ProjectUtils.setConstraint(gbc, 1, 3);
        this.add(capacityIncrementField, gbc);

        ProjectUtils.setConstraint(gbc, 1, 4);
        this.add(new JLabel(ProjectUtils.paragraph("Оберіть тип елементів вектора")), gbc);

        ProjectUtils.setConstraint(gbc, 1, 5);
        this.add(new InputField(), gbc);

        ProjectUtils.setConstraint(gbc, 1, 6);
        this.add(initButton, gbc);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        try {
            initialCapacity = Integer.parseInt(initialCapacityField.getText());
            capacityIncrement = Integer.parseInt(capacityIncrementField.getText());
        } catch (NumberFormatException e) {

        }

        this.dispose();
        System.exit(0);
    };
}