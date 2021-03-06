/**
 * SE1021
 * Winter 2016
 * Lecture 10
 * Name: Brad Dennis
 * Created: 1/06/2016
 */
package Winter2016.lecture10;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * This is a simple program that will be used to demonstrate
 * simple anonymous classes
 */
public class AnonymousClass extends JFrame implements ActionListener {
    private final JLabel instructionsLabel;
    private final JTextField usernameField;
    private final JTextArea validationArea;
    private final JButton submitButton;
    private final JButton cancelButton;

    public AnonymousClass() {
        // Step 1:  Configure the frame
        setTitle("Lab Submitter");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Step 2: Create components
        instructionsLabel = new JLabel("Username:");

        validationArea = new JTextArea(5, 20);
        validationArea.setBackground(getBackground());
        Font font = new Font("Arial", Font.ITALIC, 12);
        validationArea.setFont(font);

        usernameField = new JTextField(30);

        ArrayList<String> values = new ArrayList<>();
        values.add("appelbaumgl");
        values.add("bensonja");
        values.add("christieck");
        values.add("douglasea");
        values.add("droesedj");

        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                validationArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {

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
        });


        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");

        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Step 3: Add components to the GUI
        add(instructionsLabel);
        add(usernameField);
        add(validationArea);
        add(submitButton);
        add(cancelButton);
    }

    public final void actionPerformed(final ActionEvent e) {
        if (e.getSource() == submitButton) {
            validationArea.setText("Saved!");
        } else if (e.getSource() == cancelButton) {
            System.out.println("The old text was '" + validationArea.getText() + "'.");
            validationArea.setText("");
        }
    }

    public static void main(String[] args) {
        AnonymousClass frame = new AnonymousClass();
        frame.setVisible(true);
    }

}
