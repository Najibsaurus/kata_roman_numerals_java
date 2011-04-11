/**
 * 
 */
package de.marhan.kata.roman;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.marhan.kata.roman.RomanNumberConverter.NumberMapping;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Markus Hanses
 * 
 */
public class RomanNumberConverterMappingTest {

	private RomanNumberConverter converter;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new RomanNumberConverter();
	}

	@Test
	public void createNumberMappings_allLowerBordersCreated() throws Exception {
		List<NumberMapping> mappings = converter.createNumberMappings();
		Iterator<NumberMapping> iterator = mappings.iterator();

		NumberMapping mapping_I = iterator.next();
		assertThat(mapping_I.getRoman(), is("I"));
		assertThat(mapping_I.getArabic(), is(1));
		assertThat(mapping_I.getLowerBorder(), is(nullValue()));

		NumberMapping mapping_V = iterator.next();
		assertThat(mapping_V.getRoman(), is("V"));
		assertThat(mapping_V.getArabic(), is(5));
		assertThat(mapping_V.getLowerBorder(), is(4));

		NumberMapping mapping_X = iterator.next();
		assertThat(mapping_X.getRoman(), is("X"));
		assertThat(mapping_X.getArabic(), is(10));
		assertThat(mapping_X.getLowerBorder(), is(9));

		NumberMapping mapping_L = iterator.next();
		assertThat(mapping_L.getRoman(), is("L"));
		assertThat(mapping_L.getArabic(), is(50));
		assertThat(mapping_L.getLowerBorder(), is(40));

		NumberMapping mapping_C = iterator.next();
		assertThat(mapping_C.getRoman(), is("C"));
		assertThat(mapping_C.getArabic(), is(100));
		assertThat(mapping_C.getLowerBorder(), is(90));

		NumberMapping mapping_D = iterator.next();
		assertThat(mapping_D.getRoman(), is("D"));
		assertThat(mapping_D.getArabic(), is(500));
		assertThat(mapping_D.getLowerBorder(), is(400));

		NumberMapping mapping_M = iterator.next();
		assertThat(mapping_M.getRoman(), is("M"));
		assertThat(mapping_M.getArabic(), is(1000));
		assertThat(mapping_M.getLowerBorder(), is(900));
	}
}
