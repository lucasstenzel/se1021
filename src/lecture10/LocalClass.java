/**
 * SE1021
 * Winter 2016
 * Lecture 10
 * Name: Brad Dennis
 * Created: 1/06/2016
 */
package lecture10;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * This is a simple program that will be used to demonstrate
 * simple inner classes
 */
public class LocalClass extends JFrame {
    private final JLabel instructionsLabel;
    private final JTextField usernameField;
    private final JTextArea validationArea;
    private final JButton submitButton;

    public LocalClass() {
        // Step 1:  Configure the frame
        setTitle("Lab Submitter");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Step 2: Create components
        instructionsLabel = new JLabel("Username:");

        validationArea = new JTextArea(5, 20);
        validationArea.setBackground(getBackground());

        usernameField = new JTextField(30);


        class Validator implements FocusListener {
            ArrayList<String> values = new ArrayList<>();

            public Validator() {
                values.add("appelbaumgl");
                values.add("bensonja");
                values.add("christieck");
                values.add("douglasea");
                values.add("droesedj");
            }
            @Override
            public void focusGained(FocusEvent e) {
                validationArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                Font font = new Font("Arial", Font.ITALIC, 12);
                validationArea.setFont(font);

                validationArea.setForeground(Color.RED);
                String message = "A username is required.";

                if (values.contains(usernameField.getText())) {
                    validationArea.setForeground(Color.GREEN);
                    message = "User '" + usernameField.getText() + "' in the roster.";
                } else if (!usernameField.getText().isEmpty()) {
                    message = "User '" + usernameField.getText() + "' is not in the roster.";
                }

                validationArea.setText(message);
            }
        }


        usernameField.addFocusListener(new Validator());

        submitButton = new JButton("Submit");


        // Step 3: Add components to the GUI
        add(instructionsLabel);
        add(usernameField);
        add(validationArea);
        add(submitButton);
    }

    public static void main(String[] args) {

        LocalClass frame = new LocalClass();
        frame.setVisible(true);
    }

}
