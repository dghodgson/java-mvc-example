import java.awt.event.*;

import javax.swing.JRadioButton;

/**
 * Controller class for Phone Charges calculator </ br>
 * Handles input validation, calls on Model and View to calculate and display charges.
 *
 * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
 * @version 1.0
 */
public class PhoneChargesController
{
    private PhoneChargesModel model;
    private PhoneChargesView  view;

    /**
     * Constructor, sets the Model and View objects which the Controller will interact with, adds listeners for the buttons in the GUI
     *
     * @param m  Model object to interact with
     * @param v  View object to interact with
     */
    public PhoneChargesController(PhoneChargesModel m, PhoneChargesView  v)
    {
        model = m;
        view  = v;

        view.addCalcButtonListener(new CalcButtonListener());

        // Add a listener for each radio button in the Rate panel
        for (JRadioButton button : view.getRateButtons())
        {
            view.addRateButtonListener(button, new RateButtonListener());
        }
    }

    /**
     * Listener class for the calculate button: 
     * Validates input for durationTextField (displays error if input is invalid), 
     * calls on Model to set duration and calculate charges, 
     * calls on View to display call information
     *
     * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
     * @version 1.0
     */
    class CalcButtonListener implements  ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                String input = view.getUserInput();
                int duration = Integer.parseInt(input);

                // Duration and rate have to be set before getCharges() will return the correct value
                model.setDuration(duration);
                double charges = model.getCharges();
                double rate = model.getRate();

                view.showCharges(duration, rate, charges);
            }
            catch (NumberFormatException nfe)
            {
                view.showError("Input error", "Minutes not valid");
            }
        }
    }
}
