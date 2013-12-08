import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Enumeration;

import javax.swing.*;

/**
 * View class for Phone Charges calculator
 * Handles GUI implementation
 *
 * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
 * @version 1.1
 */
@SuppressWarnings ("serial") // No need for serialVersionUID since this class won't be serialized
public class PhoneChargesView extends JFrame
{
    private JPanel       ratePanel, durationPanel, calculatePanel;
    private JRadioButton rateDaytimeRB, rateEveningRB, rateOffpeakRB;
    private JLabel       durationLabel;
    private JTextField   durationTextField;
    private JButton      calculateButton;
    private ButtonGroup  radioButtonGroup;
    
    /**
     * Constructor, creates GUI components, sets up panels and frame
     */
    PhoneChargesView()
    {
        // Create GUI components
        rateDaytimeRB = new JRadioButton("Daytime - 8:00 a.m. to 5:00 p.m.", true);
        rateEveningRB = new JRadioButton("Evening - 5:00 p.m. to 11:00 p.m.", false);
        rateOffpeakRB = new JRadioButton("Off-Peak - 11:00 p.m. to 8:00 a.m.", false);
        
            // Put radio buttons in same group
            radioButtonGroup = new ButtonGroup();
            radioButtonGroup.add(rateDaytimeRB);
            radioButtonGroup.add(rateEveningRB);
            radioButtonGroup.add(rateOffpeakRB);

        durationLabel = new JLabel("Minutes: ");
        durationTextField = new JTextField(10);

        calculateButton = new JButton("Calculate Charges");

        // Create panels and add components
        ratePanel = new JPanel();
        ratePanel.setLayout(new GridLayout(radioButtonGroup.getButtonCount(),1));
        ratePanel.setBorder(BorderFactory.createTitledBorder("Select a Rate"));
        
        for (JRadioButton radioButton : getRateButtons())
        {
            ratePanel.add(radioButton);
        }

        durationPanel = new JPanel();
        durationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        durationPanel.setBorder(BorderFactory.createTitledBorder("Duration of Call"));
        durationPanel.add(durationLabel);
        durationPanel.add(durationTextField);

        calculatePanel = new JPanel();
        calculatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        calculatePanel.add(calculateButton);

        // Create a frame and add the panels
        this.setTitle("Phone Charges");
        this.setLayout(new BorderLayout());
        this.add(ratePanel, BorderLayout.NORTH);
        this.add(durationPanel, BorderLayout.CENTER);
        this.add(calculatePanel, BorderLayout.SOUTH);

        // Set display properties for the frame
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Gets the value entered into durationTextField by the user
     *
     * @return the duration of the call in minutes
     */
    String getUserInput()
    {
        return durationTextField.getText();
    }

    /**
     * Gets the radio buttons used for selecting the minutely rates in the Rates panel
     *
     * @return an array of JRadioButton objects, one for each radio button in the Rates panel
     */
    JRadioButton[] getRateButtons()
    {
        int size = radioButtonGroup.getButtonCount();
        JRadioButton[] array = new JRadioButton[size];
        
        // Get an enumeration of all the buttons in the ButtonGroup
        Enumeration<AbstractButton> rbgEnum = radioButtonGroup.getElements();
        
        for (int i = 0; i < array.length; i++)
        {
            // Cast the AbstractButton as a JRadioButton and add it to the array
            array[i] = (JRadioButton) rbgEnum.nextElement();
        }
        
        return array;
    }

    /**
     * Displays a message dialog with the duration of the call, the minutely rate, and the charges owed
     *
     * @param duration  the duration of the call in minutes
     * @param rate      the cost per minute for the call
     * @param charges   the charges owed
     */
    void showCharges(int duration, double rate, double charges)
    {
        DecimalFormat formatter = new DecimalFormat("#0.00");

        JOptionPane.showMessageDialog(
                null,
                duration + " minutes at the rate of $" + rate + " per minute. \n" +
                "Total Charges are $" + formatter.format(charges),
                "Phone Charges",
                JOptionPane.INFORMATION_MESSAGE
                );
    }

    /**
     * Displays an error message dialog with the provided window title and error message
     *
     * @param title    the title of the error message window
     * @param message  the error message to display
     */
    void showError(String title, String message)
    {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Adds an action listener to the specified button (for the minutely rate radio buttons)
     *
     * @param button  the button to which the action listener will be added
     * @param al      the ActionListener object to add to the button
     */
    void addRateButtonListener(JRadioButton button, ActionListener al)
    {
        button.addActionListener(al);
    }

    /**
     * Adds an action listener to the calculate button
     *
     * @param al  the ActionListener object to add to the button
     */
    void addCalcButtonListener(ActionListener al) {
        calculateButton.addActionListener(al);
    }
}
