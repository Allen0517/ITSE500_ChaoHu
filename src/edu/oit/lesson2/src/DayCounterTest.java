import static org.junit.Assert.*;

import org.junit.Test;

public class DayCounterTest {

    @Test
    public void isLeapTest() {
        assertEquals(DayCounter.isLeap(2000), true);
        assertEquals(DayCounter.isLeap(1900), false);
        assertEquals(DayCounter.isLeap(2008), true);
        assertEquals(DayCounter.isLeap(2001), false);
    }

    @Test
    public void getDaysTest() {
        assertEquals(DayCounter.getDays(true, 10), 31);
        assertEquals(DayCounter.getDays(false, 12), 31);
        assertEquals(DayCounter.getDays(true, 4), 30);
        assertEquals(DayCounter.getDays(false, 9), 30);
        assertEquals(DayCounter.getDays(true, 2), 29);
        assertEquals(DayCounter.getDays(false, 2), 28);
    }

}