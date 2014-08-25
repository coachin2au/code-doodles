/**
 * CW33 Programming exercise : This week we'll make a program to calculate days until bonus pay out
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author BFrancoeur
 * 
 */

public class DaysUntilBonus {

    /**
     * @param args
     */

    public static void main(String[] args) {

        /* constant to calculate days from mseconds */
        final long MS_IN_A_DAY = 86400000;

        /* BFTODO - someday make the payDay a CLI param, here's a default */
        Calendar defaultPayday = Calendar.getInstance();
        /* output format for dates */
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        /* difference between today and bonus day (in ms) */
        long delta = 0;

        /* Current bonus pay day is March 20, 2015 */
        defaultPayday.set(2015, Calendar.MARCH, 20);

        delta = defaultPayday.getTimeInMillis()
                - Calendar.getInstance().getTimeInMillis();

        /* Print out the date of the bonus */
        System.out.println("Today is            : "
                + dateFormat.format(Calendar.getInstance().getTime()));
        System.out.println("Your bonus comes on : "
                + dateFormat.format(defaultPayday.getTime()));
        System.out.println("You have to wait " + (delta / MS_IN_A_DAY)
                + " days until you get the bonus.");

    }

}
