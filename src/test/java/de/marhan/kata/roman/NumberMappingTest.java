/**
 * 
 */
package de.marhan.kata.roman;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Markus Hanses
 * 
 */
public class NumberMappingTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createNumberMappings_allLowerBordersCreated() throws Exception {

	NumberMappingElement mapping_I = NumberMapping.mapping_I;
	assertThat(mapping_I.getRoman(), is("I"));
	assertThat(mapping_I.getArabic(), is(1));
	assertThat(mapping_I.getLowerBorder(), is(nullValue()));

	NumberMappingElement mapping_V = NumberMapping.mapping_V;
	assertThat(mapping_V.getRoman(), is("V"));
	assertThat(mapping_V.getArabic(), is(5));
	assertThat(mapping_V.getLowerBorder(), is(4));

	NumberMappingElement mapping_X = NumberMapping.mapping_X;
	assertThat(mapping_X.getRoman(), is("X"));
	assertThat(mapping_X.getArabic(), is(10));
	assertThat(mapping_X.getLowerBorder(), is(9));

	NumberMappingElement mapping_L = NumberMapping.mapping_L;
	assertThat(mapping_L.getRoman(), is("L"));
	assertThat(mapping_L.getArabic(), is(50));
	assertThat(mapping_L.getLowerBorder(), is(40));

	NumberMappingElement mapping_C = NumberMapping.mapping_C;
	assertThat(mapping_C.getRoman(), is("C"));
	assertThat(mapping_C.getArabic(), is(100));
	assertThat(mapping_C.getLowerBorder(), is(90));

	NumberMappingElement mapping_D = NumberMapping.mapping_D;
	assertThat(mapping_D.getRoman(), is("D"));
	assertThat(mapping_D.getArabic(), is(500));
	assertThat(mapping_D.getLowerBorder(), is(400));

	NumberMappingElement mapping_M = NumberMapping.mapping_M;
	assertThat(mapping_M.getRoman(), is("M"));
	assertThat(mapping_M.getArabic(), is(1000));
	assertThat(mapping_M.getLowerBorder(), is(900));
    }
}
