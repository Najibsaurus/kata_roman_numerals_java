package de.marhan.kata.roman;

import java.util.Collections;
import java.util.List;

import de.marhan.kata.roman.util.InverseNaturalArabicSorter;

/**
 * The converter for Arabic numbers to Roman numbers.
 * 
 * @author Markus Hanses
 * 
 */
public class RomanNumberConverter {

    private final List<NumberMappingElement> numberMappings;

    public RomanNumberConverter() {
	numberMappings = NumberMapping.createNumberMappingList();
	Collections.sort(numberMappings, new InverseNaturalArabicSorter());
    }

    /**
     * Converts the arabic numerals to romans.
     * 
     * @param arabicNumber
     *            The given arabicNumeral.
     * @return The roman number for given arabic.
     */
    public String convert(Integer arabicNumber) {

	StringBuilder builder = new StringBuilder();

	NumberMappingElement mapping = findMappingForArabic(arabicNumber);
	Integer prefixValue = getPrefixValue(arabicNumber, mapping);
	String prefix = createRomanNumeralPrefixByMapping(prefixValue, mapping);
	builder.append(prefix);

	Integer differenceValue = calculateDifference(arabicNumber, prefixValue);
	if (differenceValue > 0) {
	    builder.append(convert(differenceValue));
	}

	return builder.toString();
    }

    private Integer calculateDifference(Integer arabicNumber, Integer prefixValue) {
	return arabicNumber - prefixValue;
    }

    Integer getPrefixValue(Integer arabicNumber, NumberMappingElement mapping) {
	if (arabicNumber >= mapping.getArabic()) {
	    return mapping.getArabic();
	}
	if (arabicNumber >= mapping.getLowerBorder()) {
	    return mapping.getLowerBorder();
	}

	String errorMessage = String.format("'%s' is not a arabic number of '%s'",//
		arabicNumber, mapping.getRoman());
	throw new IllegalArgumentException(errorMessage);
    }

    String createRomanNumeralPrefixByMapping(Integer prefixValue, NumberMappingElement mapping) {
	if (mapping.getArabic() > prefixValue) {
	    StringBuilder builder = new StringBuilder();
	    builder.append(mapping.getBefore().getRoman());
	    builder.append(mapping.getRoman());
	    return builder.toString();
	}
	if (mapping.getArabic() == prefixValue) {
	    return mapping.getRoman();
	}

	String errorMessage = String.format("'%s' is not in range of mapping for '%s'",//
		prefixValue, mapping.getRoman());
	throw new IllegalArgumentException(errorMessage);
    }

    NumberMappingElement findMappingForArabic(Integer arabicNumber) {
	for (NumberMappingElement mapping : numberMappings) {
	    if (isMappingForArabicNumber(arabicNumber, mapping)) {
		return mapping;
	    }
	}
	throw new IllegalStateException();
    }

    boolean isMappingForArabicNumber(Integer arabicNumber, NumberMappingElement mapping) {
	boolean found = mapping.getArabic() <= arabicNumber;
	return found || mapping.getLowerBorder() <= arabicNumber;
    }
}
