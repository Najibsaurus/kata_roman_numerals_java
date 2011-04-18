package de.marhan.kata.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import de.marhan.kata.roman.mapping.NumeralMapping;

/**
 * @author Markus Hanses
 */
public class RomanNumeralConverterPrefixFinderTest {

	private RomanNumeralConverter converter;

	@Before
	public void setUp() {
		converter = new RomanNumeralConverter();
	}

	@Test
	public void createRomanNumeralPrefixByMapping_1AndI_I() throws Exception {
		String result = converter.createRomanPrefix(1, NumeralMapping.mapping_I);
		assertThat(result, is("I"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRomanNumeralPrefixByMapping_2AndI_exception() throws Exception {
		converter.createRomanPrefix(2, NumeralMapping.mapping_I);
	}

	@Test
	public void createRomanNumeralPrefixByMapping_4AndV_IV() throws Exception {
		String result = converter.createRomanPrefix(4, NumeralMapping.mapping_V);
		assertThat(result, is("IV"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRomanNumeralPrefixByMapping_6AndV_exception() throws Exception {
		converter.createRomanPrefix(6, NumeralMapping.mapping_V);
	}

	@Test
	public void createRomanNumeralPrefixByMapping_900AndM_CM() throws Exception {
		String result = converter.createRomanPrefix(900, NumeralMapping.mapping_M);
		assertThat(result, is("CM"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void createRomanNumeralPrefixByMapping_1001AndM_exception() throws Exception {
		converter.createRomanPrefix(1001, NumeralMapping.mapping_M);
	}

}
