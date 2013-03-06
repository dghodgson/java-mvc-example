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

    /**
     * Listener class for Rate radio buttons: 
     * Calls on view to get available radio buttons, 
     * calls on Model to set rate according to which radio button is selected
     *
     * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
     * @version 1.0
     */
    class RateButtonListener implements ActionListener
    {
        //  Even though the variables we're accessing from our model are static,
        //+ if we access them through the object provided by the constructor,
        //+ we don't have to worry about whether or not we're using the same model our constructor is.
        //+ This will make debugging easier in the event we decide to implement multiple models.
        @SuppressWarnings ("static-access")
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // Get the available radio buttons in the Rate panel
            JRadioButton[] button = view.getRateButtons();

            JRadioButton daytime = button[0];
            JRadioButton evening = button[1];
            JRadioButton offpeak = button[2];

            // Check which radio button is selected and set the charge rate accordingly
            if (e.getSource() == daytime)
            {
                model.setRate(model.DAYTIME_RATE);
            }
            else if (e.getSource() == evening)
            {
                model.setRate(model.EVENING_RATE);
            }
            else if (e.getSource() == offpeak)
            {
                model.setRate(model.OFFPEAK_RATE);
            }
        }
    }

}
