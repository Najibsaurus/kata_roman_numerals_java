package de.marhan.kata.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.marhan.kata.roman.RomanNumberConverter;

/**
 * Test class for {@link RomanNumberConverter.java}.
 * 
 * @author Markus Hanses
 *
 */
public class RomanNumberConverterTest {

	RomanNumberConverter converter = new RomanNumberConverter();

	@Test
	public void convert_one_I() throws Exception {
		assertThat(converter.convert(1), is(TestData.getRomanForNumber(1)));
	}

	@Test
	public void convert_till3_success() throws Exception {
		for (int i = 1; i <= 3; i++) {
			assertThat(converter.convert(i), is(TestData.getRomanForNumber(i)));
		}
	}

	@Test
	public void convert_till8_success() throws Exception {
		for (int i = 1; i <= 8; i++) {
			assertThat(converter.convert(i), is(TestData.getRomanForNumber(i)));
		}
	}

	@Test
	public void convert_1_I() throws Exception {
		assertThat(converter.convert(1), is(TestData.getRomanForNumber(1)));
	}

	@Test
	public void convert_5_V() throws Exception {
		assertThat(converter.convert(1), is(TestData.getRomanForNumber(1)));
	}
}
