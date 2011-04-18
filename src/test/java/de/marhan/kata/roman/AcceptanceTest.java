package de.marhan.kata.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Acceptance test class for {@link RomanNumeralConverter.java}.
 * 
 * @author Markus Hanses
 */
public class AcceptanceTest {

	@Test
	public void convert_all_success() throws Exception {
		RomanNumeralConverter converter = new RomanNumeralConverter();
		for (int i = 1; i <= AcceptanceTestData.getLengthOfData(); i++) {
			assertThat(converter.convert(i), is(AcceptanceTestData.getRomanForNumber(i)));
		}
	}

}
