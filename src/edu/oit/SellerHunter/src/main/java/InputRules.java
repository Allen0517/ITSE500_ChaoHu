import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IT on 2017/6/16.
 */
public class InputRules {
    private JButton OKButton;
    private JButton closeButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JTextField textField4;
    private JPanel InputPanel;
    private JPanel Inputpanel;

    public String countryZone;
    public String shipFeeFilter = "original";
    public String conditionFilter = "All";
    public int positiveFilter = 95;
    public int ratingFilter = 100;

    public InputRules() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // We have to parse the text to a type float.
                countryZone = comboBox1.getSelectedItem().toString();
                shipFeeFilter = textField1.getText();
                conditionFilter = textField2.getText();
                positiveFilter = Integer.parseInt(textField3.getText());
                ratingFilter = Integer.parseInt(textField4.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InputRules");
        frame.setContentPane(new InputRules().Inputpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
