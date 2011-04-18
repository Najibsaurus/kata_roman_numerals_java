package de.marhan.kata.roman.mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Markus Hanses
 */
public class NumeralMapping {

	public static NumeralMappingElement mapping_I = NumeralMappingElement//
			.newInstance(1, "I");

	public static NumeralMappingElement mapping_V = NumeralMappingElement//
			.newInstance(mapping_I, 5, "V");

	public static NumeralMappingElement mapping_X = NumeralMappingElement//
			.newInstance(mapping_I, 10, "X");

	public static NumeralMappingElement mapping_L = NumeralMappingElement//
			.newInstance(mapping_X, 50, "L");

	public static NumeralMappingElement mapping_C = NumeralMappingElement//
			.newInstance(mapping_X, 100, "C");

	public static NumeralMappingElement mapping_D = NumeralMappingElement//
			.newInstance(mapping_C, 500, "D");

	public static NumeralMappingElement mapping_M = NumeralMappingElement//
			.newInstance(mapping_C, 1000, "M");

	/**
	 * Create the a list of all defined mappings for arabic and roman numerals.
	 * 
	 * @return The list of mappings.
	 */
	public static List<NumeralMappingElement> createNumeralMappingList() {
		List<NumeralMappingElement> numeralMappings = new ArrayList<NumeralMappingElement>();
		numeralMappings.add(mapping_I);
		numeralMappings.add(mapping_V);
		numeralMappings.add(mapping_X);
		numeralMappings.add(mapping_L);
		numeralMappings.add(mapping_C);
		numeralMappings.add(mapping_D);
		numeralMappings.add(mapping_M);
		return numeralMappings;
	}
}
