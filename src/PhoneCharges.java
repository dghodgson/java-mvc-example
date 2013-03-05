import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PhoneCharges
{

    public PhoneCharges()
    {
        
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
