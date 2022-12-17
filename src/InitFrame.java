import components.*;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;


public class InitFrame extends JFrame {
    private ElementsType type;
    private int initialCapacity;
    private int capacityIncrement;
    private final String description = """
        Дана пронрама є візуалізацією вектора.
        Спочатку необхідно встановити початкові налаштування вектора, а саме
        обрати тип елементів, встановити початкову місткість та інкременту
        місткості, тобто число на котре буде збільшуватися місткість після
        переповнення.
        """;

    public InitFrame() {
        super();

        Vector typeNames = new Vector<String>();
        for (ElementsType type : ElementsType.values())
            typeNames.add(type.name);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new BoxLayout(descriptionPanel, BoxLayout.Y_AXIS));
        descriptionPanel.add(new TitleLabel("Короткий опис"));
        descriptionPanel.add(new MainLabel(description));

        JPanel actionPanel = new JPanel();
        actionPanel.add(new MainLabel("Оберіть тип"));
        actionPanel.add(new JComboBox<String>(typeNames));
        actionPanel.add(new MainLabel("Введіть початкову місткість"));
        actionPanel.add(new MainTextField());
        actionPanel.add(new MainLabel("Введіть інкременту місткісті"));
        actionPanel.add(new MainTextField());
        actionPanel.add(new MainButton("OK"));

        this.setTitle("Ініціалізація вектора");
        this.setMinimumSize(new Dimension(500, 400));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.add(descriptionPanel);
        this.add(actionPanel);

        this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
}