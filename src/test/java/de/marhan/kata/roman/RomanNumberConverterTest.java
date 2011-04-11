package de.marhan.kata.roman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class for {@link RomanNumberConverter.java}.
 * 
 * @author Markus Hanses
 * 
 */
public class RomanNumberConverterTest {

	RomanNumberConverter converter = new RomanNumberConverter();

	@Test
	public void convert_till3_success() throws Exception {
		for (int i = 1; i <= 1000; i++) {
			assertThat(converter.convert(i), is(TestData.getRomanForNumber(i)));
		}
	}

}
