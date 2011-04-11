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

	private final List<NumberMapping> numberMappings;

	public RomanNumberConverter() {
		numberMappings = createNumberMappings();
	}

	protected List<NumberMapping> createNumberMappings() {
		List<NumberMapping> romanNumbers = new ArrayList<NumberMapping>();
		NumberMapping mapping_I = NumberMapping.newInstance(1, "I");
		romanNumbers.add(mapping_I);
		NumberMapping mapping_V = NumberMapping.newInstance(mapping_I, 5, "V");
		romanNumbers.add(mapping_V);
		NumberMapping mapping_X = NumberMapping.newInstance(mapping_I, 10, "X");
		romanNumbers.add(mapping_X);
		NumberMapping mapping_L = NumberMapping.newInstance(mapping_X, 50, "L");
		romanNumbers.add(mapping_L);
		NumberMapping mapping_C = NumberMapping
				.newInstance(mapping_X, 100, "C");
		romanNumbers.add(mapping_C);
		NumberMapping mapping_D = NumberMapping
				.newInstance(mapping_C, 500, "D");
		romanNumbers.add(mapping_D);
		NumberMapping mapping_M = NumberMapping.newInstance(mapping_C, 1000,
				"M");
		romanNumbers.add(mapping_M);

		computeLowerBorders(romanNumbers);
		return romanNumbers;
	}

	protected void computeLowerBorders(List<NumberMapping> mappings) {
		for (NumberMapping mapping : mappings) {
			mapping.computeLowerBorder();
		}
	}

	public String convert(int number) {

		StringBuilder builder = new StringBuilder();

		if (isForward(number)) {

		}

		return builder.toString();
	}

	private boolean isForward(int number) {

		return false;
	}

	protected String romanGroupOfArabicNumber(int arabicNumber) {
		NumberMapping numberMapping = numberMappings
				.get(numberMappings.size() - 1);
		while (numberMapping.hasBefore()) {
			if (arabicNumber > numberMapping.getLowerBorder()) {
				break;
			}
			numberMapping = numberMapping.before;
		}
		return numberMapping.getRoman();
	}

	/**
	 * 
	 * @author Markus Hanses
	 * 
	 */
	protected static class NumberMapping {

		private NumberMapping before;

		private String roman;

		private Integer arabic;

		private Integer lowerBorder;

		public static NumberMapping newInstance(NumberMapping before,
				Integer number, String roman) {
			NumberMapping mapping = new NumberMapping();
			mapping.before = before;
			mapping.roman = roman;
			mapping.arabic = number;
			return mapping;
		}

		public static NumberMapping newInstance(Integer number, String roman) {
			NumberMapping mapping = new NumberMapping();
			mapping.roman = roman;
			mapping.arabic = number;
			return mapping;
		}

		public void computeLowerBorder() {
			if (before != null) {
				Integer arabicOfSubstractionGroup = before.arabic;
				lowerBorder = arabic - arabicOfSubstractionGroup;
			}
		}

		public String getRoman() {
			return roman;
		}

		public Integer getArabic() {
			return arabic;
		}

		public NumberMapping getBefore() {
			return before;
		}

		public boolean hasBefore() {
			return before != null;
		}

		public Integer getLowerBorder() {
			return lowerBorder;
		}
	}
}
