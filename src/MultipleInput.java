import javax.swing.*;

/**
 * Dialog window for multiple (2) inputs.
 */
public class MultipleInput {

    private String label1;  // первый input

    private String label2;  // второй input

    private String title; // название окна

    public static String[] render(String label1, String label2, String title) {
        JTextField firstField = new JTextField(10); /// columns – размер поля edit
        JTextField secondField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel(label1));
        myPanel.add(firstField);
        myPanel.add(Box.createHorizontalStrut(10)); // размер padding между input
        myPanel.add(new JLabel(label2));
        myPanel.add(secondField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
            title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {

            String[] inputValues = new String[2];
            inputValues[0] = firstField.getText();
            inputValues[1] = secondField.getText();

            return inputValues;
        }
        return null;
    }

}

