package de.marhan.kata.roman;

import java.util.ArrayList;
import java.util.List;

/**
 * The converter for Arabic numbers to Roman numbers.
 *
 * @author Markus Hanses
 *
 */
public class RomanNumberConverter {

	private static String ONE = "I";

	private static String FIVE = "V";

	private List<MappingEntry> romanNumbers = new ArrayList<MappingEntry>();

	RomanNumberConverter() {
		romanNumbers.add(new MappingEntry(1, ONE));
		romanNumbers.add(new MappingEntry(5, FIVE));
	}

	public String convert(int number) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < romanNumbers.size(); i++) {
			MappingEntry mappingEntry = romanNumbers.get(i);
			if (mappingEntry.number == number) {
				return mappingEntry.roman;
			}
			if (mappingEntry.number > number) {
				if (isCurrentGroup(number, mappingEntry, romanNumbers.get(i - 1))) {
					builder.append(romanNumbers.get(i - 1).roman);
					builder.append(mappingEntry.roman);

					//
				} else {

				}
			}
		}

		return builder.toString();
	}


	private boolean isCurrentGroup(int number, MappingEntry current, MappingEntry before) {
		Integer min = current.number - before.number;
		return number < min;
	}


	class MappingEntry {
		String roman;

		Integer number;

		MappingEntry(Integer number, String roman) {
			this.roman = roman;
			this.number = number;
		}

	}
}
