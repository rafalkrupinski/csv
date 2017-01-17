package com.hashnot.csv.sage.convert;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author Rafał Krupiński
 */
public class SageDateTest {
    @Test
    public void testParse() {
        LocalDate date = SageDate.formatter.parse("01/01/2016", LocalDate::from);
        LocalDate expexted = LocalDate.of(2016, 1, 1);
        assertEquals(expexted, date);
    }

    @Test
    public void testFormat() throws Exception {
        String dateStr = SageDate.formatter.format(LocalDate.of(2016, 1, 1));
        String expected = "01/01/2016";
        assertEquals(expected, dateStr);
    }
}
