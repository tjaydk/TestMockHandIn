/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import Exceptions.InvalidTimeZoneException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Dennis
 */
@RunWith(Parameterized.class)
public class DateFormatterTest {
    
    private static String formatStr = "dd MMM yyyy hh:mm aa";
    private static SimpleDateFormat format;
    private static Date date;
    
    @Parameter(0)
    public String timeZone;
    
    @Parameter(1)
    public String expectedResult;
    
    @Parameter(2)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Parameters
    public static Iterable<Object[]> setupTestData() {
        return Arrays.asList(new Object[][]{
            {"Europe/Copenhagen", "13 apr. 2017 12:00 PM", null},
            {"Europe/London", "13 apr. 2017 11:00 AM", null},
            {"Invalid/Timezone", "13 apr. 2017 12:00 PM", InvalidTimeZoneException.class}
        });
    }
    
    
    @BeforeClass
    public static void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 3, 13, 12, 00); // sets the specific date to 13 apr. 2017 12:00 PM.
        
        date    = cal.getTime();
        format  = new SimpleDateFormat(formatStr);
    }
    
    @Test
    public void testGetFormattedDate() throws InvalidTimeZoneException {
        if (expectedException != null) {
            thrown.expect(expectedException);
        }
        
        DateFormatter df            = new DateFormatter(date, format);
        String dateStr              = df.getFormattedDate(timeZone);
        String assertStr            = expectedResult;
        
        assertThat(dateStr).isEqualTo(assertStr);
    }
}
