import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

/**
 * View class for Phone Charges calculator
 * Handles GUI implementation
 *
 * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
 * @version 1.0
 */
public class PhoneChargesView extends JFrame
{
    private JPanel       ratePanel, durationPanel, calculatePanel;
    private JRadioButton rateDaytimeRB, rateEveningRB, rateOffpeakRB;
    private JLabel       durationLabel;
    private JTextField   durationTextField;
    private JButton      calculateButton;

    /**
     * Constructor, creates GUI components, sets up panels and frame
     */
    PhoneChargesView()
    {
        final int WINDOW_WIDTH = 280;
        final int WINDOW_HEIGHT = 235;

        // Create GUI components
        rateDaytimeRB = new JRadioButton("Daytime - 8:00 a.m. to 5:00 p.m.", true);
        rateEveningRB = new JRadioButton("Evening - 5:00 p.m. to 11:00 p.m.", false);
        rateOffpeakRB = new JRadioButton("Off-Peak - 11:00 p.m. to 8:00 a.m.", false);

            // Put radio buttons in same group
            ButtonGroup group = new ButtonGroup();
            group.add(rateDaytimeRB);
            group.add(rateEveningRB);
            group.add(rateOffpeakRB);

        durationLabel = new JLabel("Minutes: ");
        durationTextField = new JTextField(10);

        calculateButton = new JButton("Calculate Charges");

        // Create panels and add components
        ratePanel = new JPanel();
        ratePanel.setLayout(new GridLayout(3,1));
        ratePanel.setBorder(BorderFactory.createTitledBorder("Select a Rate"));
        ratePanel.add(rateDaytimeRB);
        ratePanel.add(rateEveningRB);
        ratePanel.add(rateOffpeakRB);

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
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(ratePanel);
        this.add(durationPanel);
        this.add(calculatePanel);

        // Set display properties for the frame
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
