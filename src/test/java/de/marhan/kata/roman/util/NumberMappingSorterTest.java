package de.marhan.kata.roman.util;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.marhan.kata.roman.mapping.NumeralMapping;
import de.marhan.kata.roman.mapping.NumeralMappingElement;

/**
 * @author Markus Hanses
 */
public class NumberMappingSorterTest {

	List<NumeralMappingElement> mappings;

	@Before
	public void setUp() {
		mappings = NumeralMapping.createNumeralMappingList();
	}

	@Test
	public void sort_arabicInInverseNaturalOrder() throws Exception {
		Collections.sort(mappings, new InverseNaturalArabicSorter());
		assertArabicSortingIsInverseNatural(mappings);
	}

	private void assertArabicSortingIsInverseNatural(List<NumeralMappingElement> mappings) {
		Integer before = 1001;
		for (NumeralMappingElement mapping : mappings) {
			assertThat(mapping.getArabic(), is(lessThan(before)));
			before = mapping.getArabic();
		}
	}
}
