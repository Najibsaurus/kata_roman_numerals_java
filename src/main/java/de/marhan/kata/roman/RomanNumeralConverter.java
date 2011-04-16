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
public class RomanNumeralConverter {

    private final List<NumeralMappingElement> numberMappings;

    public RomanNumeralConverter() {
	numberMappings = NumeralMapping.createNumeralMappingList();
	Collections.sort(numberMappings, new InverseNaturalArabicSorter());
    }

    /**
     * Converts the arabic numerals to romans.
     * 
     * @param arabicNumeral
     *            The given arabicNumeral.
     * @return The roman number for given arabic.
     */
    public String convert(Integer arabicNumeral) {
	StringBuilder builder = new StringBuilder();
	NumeralMappingElement mapping = findMappingForArabic(arabicNumeral);
	Integer prefixValue = getPrefixValue(arabicNumeral, mapping);
	builder.append(createRomanNumeralPrefixByMapping(prefixValue, mapping));
	builder.append(convertTheDifference(arabicNumeral, prefixValue));
	return builder.toString();
    }

    private String convertTheDifference(Integer arabicNumeral, Integer prefixValue) {
	Integer differenceValue = calculateDifference(arabicNumeral, prefixValue);
	if (isThereADifference(differenceValue)) {
	    return convert(differenceValue);
	}
	return "";
    }

    private boolean isThereADifference(Integer differenceValue) {
	return differenceValue > 0;
    }

    private Integer calculateDifference(Integer arabicNumber, Integer prefixValue) {
	return arabicNumber - prefixValue;
    }

    Integer getPrefixValue(Integer arabicNumber, NumeralMappingElement mapping) {
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

    String createRomanNumeralPrefixByMapping(Integer prefixValue, NumeralMappingElement mapping) {
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

    NumeralMappingElement findMappingForArabic(Integer arabicNumber) {
	for (NumeralMappingElement mapping : numberMappings) {
	    if (isMappingForArabicNumber(arabicNumber, mapping)) {
		return mapping;
	    }
	}
	throw new IllegalStateException();
    }

    boolean isMappingForArabicNumber(Integer arabicNumber, NumeralMappingElement mapping) {
	boolean found = mapping.getArabic() <= arabicNumber;
	return found || mapping.getLowerBorder() <= arabicNumber;
    }
}
