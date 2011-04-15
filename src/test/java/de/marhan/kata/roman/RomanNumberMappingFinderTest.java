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

/**
 * @author Markus Hanses
 * 
 */
public class RomanNumberMappingFinderTest {

    private RomanNumberConverter converter;

    private Map<Integer, String> arabicToMapping;

    @Before
    public void setUp() {
	converter = new RomanNumberConverter();
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
	    NumberMappingElement mapping = converter.findMappingForArabic(arabic);
	    assertThat(mapping.getRoman(), is(arabicToMapping.get(arabic)));
	}
    }

    @Test
    public void isMappingForArabicNumber_1AndI_true() throws Exception {
	boolean result = converter.isMappingForArabicNumber(1, NumberMapping.mapping_I);
	assertThat(result, is(true));
    }

    @Test
    public void isMappingForArabicNumber_899AndD_true() throws Exception {
	boolean result = converter.isMappingForArabicNumber(899, NumberMapping.mapping_D);
	assertThat(result, is(true));
    }

    @Test
    public void isMappingForArabicNumber_899AndM_false() throws Exception {
	boolean result = converter.isMappingForArabicNumber(899, NumberMapping.mapping_M);
	assertThat(result, is(false));
    }

    @Test
    public void isMappingForArabicNumber_900AndM_true() throws Exception {
	boolean result = converter.isMappingForArabicNumber(900, NumberMapping.mapping_M);
	assertThat(result, is(true));
    }

    @Test
    public void isMappingForArabicNumber_1000AndM_true() throws Exception {
	boolean result = converter.isMappingForArabicNumber(1000, NumberMapping.mapping_M);
	assertThat(result, is(true));
    }

}
