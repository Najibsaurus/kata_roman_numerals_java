/**
 * 
 */
package de.marhan.kata.roman;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.marhan.kata.roman.mapping.NumeralMapping;
import de.marhan.kata.roman.mapping.NumeralMappingElement;

/**
 * @author Markus Hanses
 * 
 */
public class RomanNumeralConverterMappingFinderTest {

    private RomanNumeralConverter converter;

    private Map<Integer, String> arabicToMapping;

    @Before
    public void setUp() {
	converter = new RomanNumeralConverter();
	arabicToMapping = new HashMap<Integer, String>();

	arabicToMapping.put(1, "I");
	arabicToMapping.put(2, "I");
	arabicToMapping.put(5, "V");
	arabicToMapping.put(4, "V");
	arabicToMapping.put(9, "X");
	arabicToMapping.put(10, "X");
	arabicToMapping.put(50, "L");
	arabicToMapping.put(100, "C");
	arabicToMapping.put(500, "D");
	arabicToMapping.put(899, "D");
	arabicToMapping.put(900, "M");
	arabicToMapping.put(1000, "M");
	arabicToMapping.put(10000, "M");
    }

    @Test
    public void findMappingForArabic_numberGiven_mappingFound() throws Exception {
	for (Integer arabic : arabicToMapping.keySet()) {
	    NumeralMappingElement mapping = converter.findMappingForArabic(arabic);
	    assertThat(mapping.getRoman(), is(arabicToMapping.get(arabic)));
	}
    }

    @Test
    public void isMappingForArabicNumber_1AndI_true() throws Exception {
	boolean result = converter.isMappingForArabic(1, NumeralMapping.mapping_I);
	assertThat(result, is(true));
    }

    @Test
    public void isMappingForArabicNumber_899AndD_true() throws Exception {
	boolean result = converter.isMappingForArabic(899, NumeralMapping.mapping_D);
	assertThat(result, is(true));
    }

    @Test
    public void isMappingForArabicNumber_899AndM_false() throws Exception {
	boolean result = converter.isMappingForArabic(899, NumeralMapping.mapping_M);
	assertThat(result, is(false));
    }

    @Test
    public void isMappingForArabicNumber_900AndM_true() throws Exception {
	boolean result = converter.isMappingForArabic(900, NumeralMapping.mapping_M);
	assertThat(result, is(true));
    }

    @Test
    public void isMappingForArabicNumber_1000AndM_true() throws Exception {
	boolean result = converter.isMappingForArabic(1000, NumeralMapping.mapping_M);
	assertThat(result, is(true));
    }

}
