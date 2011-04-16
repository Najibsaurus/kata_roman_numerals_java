package de.marhan.kata.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test class for {@link RomanNumeralConverter.java}.
 * 
 * @author Markus Hanses
 * 
 */
public class RomanNumeralConverterTest {

    RomanNumeralConverter converter = new RomanNumeralConverter();

    @Test
    public void convert_all_success() throws Exception {
	for (int i = 1; i <= TestData.getLengthOfData(); i++) {
	    assertThat(converter.convert(i), is(TestData.getRomanForNumber(i)));
	}
    }

}
