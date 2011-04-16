package de.marhan.kata.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test class for {@link RomanNumberConverter.java}.
 * 
 * @author Markus Hanses
 * 
 */
public class RomanNumberConverterTest {

    RomanNumberConverter converter = new RomanNumberConverter();

    @Test
    public void convert_all_success() throws Exception {
	for (int i = 1; i <= TestData.getLengthOfData(); i++) {
	    assertThat(converter.convert(i), is(TestData.getRomanForNumber(i)));
	}
    }

    @Test
    public void createRomanNumeralPrefixByMapping_1AndI_I() throws Exception {
	String result = converter.createRomanNumeralPrefixByMapping(1, NumberMapping.mapping_I);
	assertThat(result, is("I"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRomanNumeralPrefixByMapping_2AndI_exception() throws Exception {
	converter.createRomanNumeralPrefixByMapping(2, NumberMapping.mapping_I);
    }

    @Test
    public void createRomanNumeralPrefixByMapping_4AndV_IV() throws Exception {
	String result = converter.createRomanNumeralPrefixByMapping(4, NumberMapping.mapping_V);
	assertThat(result, is("IV"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRomanNumeralPrefixByMapping_6AndV_exception() throws Exception {
	converter.createRomanNumeralPrefixByMapping(6, NumberMapping.mapping_V);
    }

    @Test
    public void createRomanNumeralPrefixByMapping_900AndM_CM() throws Exception {
	String result = converter.createRomanNumeralPrefixByMapping(900, NumberMapping.mapping_M);
	assertThat(result, is("CM"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRomanNumeralPrefixByMapping_1001AndM_exception() throws Exception {
	converter.createRomanNumeralPrefixByMapping(1001, NumberMapping.mapping_M);
    }
}
