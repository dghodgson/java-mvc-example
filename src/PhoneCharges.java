/**
 * Main class for Phone Charges calculator </ br>
 * Creates the Model, View, and Controller objects, and sets the GUI's visibility to true
 *
 * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
 * @version 1.0
 */
public class PhoneCharges
{
    public static void main(String[] args)
    {
        PhoneChargesModel      model      = new PhoneChargesModel();
        PhoneChargesView       view       = new PhoneChargesView();
        PhoneChargesController controller = new PhoneChargesController(model, view);

        view.setVisible(true);
    }
}
