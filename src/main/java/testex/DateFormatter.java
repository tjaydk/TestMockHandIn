package testex;

import Exceptions.InvalidTimeZoneException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatter {

    //Private variables for class
    private Date time;
    private SimpleDateFormat simpleFormat;

    /**
     * Public constructor that takes a time, simpleformat and dateTimeFormat string.
     * @param Date
     * @param SimpleDateFormat
     */
    public DateFormatter(Date time, SimpleDateFormat simpleFormat) {
        this.time               = time;
        this.simpleFormat       = simpleFormat;
    }

    /**
     * Returns a formatted string representing NOW, adjusted to the time zone
     * string passed in.
     *
     * @param       String.Must be a valid time zone as returned
     *              by:TimeZone.getAvailableIDs()
     * 
     * @return      Time Zone string formatted like ("dd MMM yyyy hh:mm aa") and
     *              adjusted to the provided time zone
     * @throws      JokeException If the timeZone string is not a valid string
     */
    public String getFormattedDate(String timeZone) throws InvalidTimeZoneException {
        simpleFormat.setTimeZone(getTimeZone(timeZone));
        return simpleFormat.format(time);
    }
    
    
    /**
     * Returns time zone from a given time zone string.
     * 
     * @param       timeZone string
     * @return      TimeZone
     * @throws      JokeException 
     */
    private TimeZone getTimeZone(String timeZone) throws InvalidTimeZoneException {
        if (!Arrays.asList(TimeZone.getAvailableIDs()).contains(timeZone)) {
            throw new InvalidTimeZoneException("Invalid TimeZone");
        }
        return TimeZone.getTimeZone(timeZone);
    }
    
    
    /**
     * Returns the time.
     * @return Date
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets the time
     * @param Date
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * Returns the simpleFormat
     * @return SimpeDateFormat
     */
    public SimpleDateFormat getSimpleFormat() {
        return simpleFormat;
    }

    /**
     * Sets the SimpleDateFormat
     * @param SimpleDateFormat 
     */
    public void setSimpleFormat(SimpleDateFormat simpleFormat) {
        this.simpleFormat = simpleFormat;
    }
}
