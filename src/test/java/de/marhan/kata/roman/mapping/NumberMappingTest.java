/**
 * 
 */
package de.marhan.kata.roman.mapping;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author Markus Hanses
 */
public class NumberMappingTest {

	@Test
	public void createNumberMappings_allLowerBordersCreated() throws Exception {

		NumeralMappingElement mapping_I = NumeralMapping.mapping_I;
		assertThat(mapping_I.getRoman(), is("I"));
		assertThat(mapping_I.getArabic(), is(1));
		assertThat(mapping_I.getLowerBorder(), is(nullValue()));

		NumeralMappingElement mapping_V = NumeralMapping.mapping_V;
		assertThat(mapping_V.getRoman(), is("V"));
		assertThat(mapping_V.getArabic(), is(5));
		assertThat(mapping_V.getLowerBorder(), is(4));

		NumeralMappingElement mapping_X = NumeralMapping.mapping_X;
		assertThat(mapping_X.getRoman(), is("X"));
		assertThat(mapping_X.getArabic(), is(10));
		assertThat(mapping_X.getLowerBorder(), is(9));

		NumeralMappingElement mapping_L = NumeralMapping.mapping_L;
		assertThat(mapping_L.getRoman(), is("L"));
		assertThat(mapping_L.getArabic(), is(50));
		assertThat(mapping_L.getLowerBorder(), is(40));

		NumeralMappingElement mapping_C = NumeralMapping.mapping_C;
		assertThat(mapping_C.getRoman(), is("C"));
		assertThat(mapping_C.getArabic(), is(100));
		assertThat(mapping_C.getLowerBorder(), is(90));

		NumeralMappingElement mapping_D = NumeralMapping.mapping_D;
		assertThat(mapping_D.getRoman(), is("D"));
		assertThat(mapping_D.getArabic(), is(500));
		assertThat(mapping_D.getLowerBorder(), is(400));

		NumeralMappingElement mapping_M = NumeralMapping.mapping_M;
		assertThat(mapping_M.getRoman(), is("M"));
		assertThat(mapping_M.getArabic(), is(1000));
		assertThat(mapping_M.getLowerBorder(), is(900));
	}
}
