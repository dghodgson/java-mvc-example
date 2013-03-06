/**
 * Model class for Phone Charges calculator
 * Handles logical functionality
 *
 * @author Daniel Hodgson (daniel.hodgson@codeprogrammers.net)
 * @version 1.0
 */
public class PhoneChargesModel
{
    // Minutely rates in USD
    public static final double DAYTIME_RATE = 0.25;
    public static final double EVENING_RATE = 0.12;
    public static final double OFFPEAK_RATE = 0.05;

    private double rate  = DAYTIME_RATE; // Radio button in Rate panel defaults to Daytime, so default rate is DAYTIME_RATE
    private int duration = 0;

    /**
     * Gets the minutely rate
     *
     * @return the rate
     */
    public double getRate()
    {
        return rate;
    }

    /**
     * Sets the minutely rate
     *
     * @param r the rate to set
     */
    public void setRate(double r)
    {
        rate = r;
    }

    /**
     * Gets the call duration
     *
     * @return the duration
     */
    public int getDuration()
    {
        return duration;
    }

    /**
     * Sets the call duration
     *
     * @param d the duration to set
     */
    public void setDuration(int d)
    {
        duration = d;
    }

    /**
     * Gets the charges owed
     *
     * @return charges owed as a function of rate * duration
     */
    public double getCharges()
    {
        return rate * duration;
    }

}
