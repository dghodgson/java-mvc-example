import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PhoneCharges
{
    private static JFrame       phoneChargesFrame;
    private static JPanel       phoneChargesRatePanel, phoneChargesDurationPanel, phoneChargesButtonPanel;
    private static JRadioButton phoneChargesRateDaytimeRB, phoneChargesRateEveningRB, phoneChargesRateOffpeakRB;
    private static JLabel       phoneChargesDurationLabel;
    private static JTextField   phoneChargesDurationTextField;
    private static JButton      phoneChargesButton;
    
    public PhoneCharges()
    {
        final double DAYTIME_RATE = 0.25;
        final double EVENING_RATE = 0.12;
        final double OFFPEAK_RATE = 0.05;

        // Create GUI components
        phoneChargesRateDaytimeRB = new JRadioButton("Daytime - 8:00 a.m. to 5:00 p.m.", true);
        phoneChargesRateEveningRB = new JRadioButton("Evening - 5:00 p.m. to 11:00 p.m.", false);
        phoneChargesRateOffpeakRB = new JRadioButton("Off-Peak - 11:00 p.m. to 8:00 a.m.", false);
        
        ButtonGroup group = new ButtonGroup();
        group.add(phoneChargesRateDaytimeRB);
        group.add(phoneChargesRateEveningRB);
        group.add(phoneChargesRateOffpeakRB);
        
        phoneChargesRateDaytimeRB.addActionListener(new RadioButtonListener(DAYTIME_RATE));
        phoneChargesRateEveningRB.addActionListener(new RadioButtonListener(EVENING_RATE));
        phoneChargesRateOffpeakRB.addActionListener(new RadioButtonListener(OFFPEAK_RATE));

        phoneChargesDurationLabel = new JLabel("Minutes: ");
        phoneChargesDurationTextField = new JTextField(10);
        
        phoneChargesButton = new JButton("Calculate Charges");
        phoneChargesButton.addActionListener(new CalcButtonListener());

        // Create panels and add components
        phoneChargesRatePanel = new JPanel();
        phoneChargesRatePanel.setLayout(new GridLayout(3,1));
        phoneChargesRatePanel.setBorder(BorderFactory.createTitledBorder("Select a Rate"));
        phoneChargesRatePanel.add(phoneChargesRateDaytimeRB);
        phoneChargesRatePanel.add(phoneChargesRateEveningRB);
        phoneChargesRatePanel.add(phoneChargesRateOffpeakRB);
        
        phoneChargesDurationPanel = new JPanel();
        phoneChargesDurationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        phoneChargesDurationPanel.setBorder(BorderFactory.createTitledBorder("Duration of Call"));
        phoneChargesDurationPanel.add(phoneChargesDurationLabel);
        phoneChargesDurationPanel.add(phoneChargesDurationTextField);
        
        phoneChargesButtonPanel = new JPanel();
        phoneChargesDurationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        phoneChargesButtonPanel.add(phoneChargesButton);
    }

    private class RadioButtonListener implements ActionListener
    {

        private double rate;
        
        public RadioButtonListener(double r)
        {
            rate = r;
        }
        
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            // TODO Auto-generated method stub
            
        }
        
    }
    
    private class CalcButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            // TODO Auto-generated method stub
            
        }
        
    }

    public static void main(String[] args)
    {
        new PhoneCharges();
    }
}
