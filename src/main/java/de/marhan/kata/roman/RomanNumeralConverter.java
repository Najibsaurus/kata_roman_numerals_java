package de.marhan.kata.roman;

import java.util.Collections;
import java.util.List;

import de.marhan.kata.roman.mapping.NumeralMapping;
import de.marhan.kata.roman.mapping.NumeralMappingElement;
import de.marhan.kata.roman.util.InverseNaturalArabicSorter;

/**
 * The converter for arabic numerals to roman numerals.
 * 
 * @author Markus Hanses
 * 
 */
public class RomanNumeralConverter {

    private final List<NumeralMappingElement> numeralMappings;

    public RomanNumeralConverter() {
	numeralMappings = NumeralMapping.createNumeralMappingList();
	Collections.sort(numeralMappings, new InverseNaturalArabicSorter());
    }

    /**
     * Converts the arabic numerals to romans.
     * 
     * @param arabicNumeral
     *            The given arabicNumeral.
     * @return The roman number for given arabic.
     */
    public String convert(Integer arabicNumeral) {
	NumeralMappingElement mapping = findMappingForArabic(arabicNumeral);
	Integer arabicPrefix = findArabicPrefix(arabicNumeral, mapping);
	String romanPrefix = createRomanPrefix(arabicPrefix, mapping);

	StringBuilder builder = new StringBuilder();
	builder.append(romanPrefix);
	builder.append(convertTheSuffix(arabicNumeral, arabicPrefix));
	return builder.toString();
    }

    /**
     * Calculate the difference of prefix and the arabic numeral to converts it
     * by recursion.
     * 
     * @param arabicNumeral
     *            The original arabic numeral to convert.
     * @param prefixValue
     *            The first roman numeral, which was found.
     * @return
     */
    String convertTheSuffix(Integer arabicNumeral, Integer prefixValue) {
	Integer arabicSuffix = calculateDifference(arabicNumeral, prefixValue);
	if (isThereANumeralToConvert(arabicSuffix)) {
	    return convert(arabicSuffix);
	}
	return "";
    }

    boolean isThereANumeralToConvert(Integer arabicNumeral) {
	return arabicNumeral > 0;
    }

    Integer calculateDifference(Integer arabicNumber, Integer prefixValue) {
	return arabicNumber - prefixValue;
    }

    Integer findArabicPrefix(Integer arabicNumber, NumeralMappingElement mapping) {
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

    String createRomanPrefix(Integer prefixValue, NumeralMappingElement mapping) {
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

    NumeralMappingElement findMappingForArabic(Integer arabicNumeral) {
	for (NumeralMappingElement mapping : numeralMappings) {
	    if (isMappingForArabic(arabicNumeral, mapping)) {
		return mapping;
	    }
	}

	String errorMessage = String.format("'%s' is not defined in range of mappings",
		arabicNumeral);
	throw new IllegalStateException(errorMessage);
    }

    boolean isMappingForArabic(Integer arabicNumeral, NumeralMappingElement mapping) {
	boolean found = mapping.getArabic() <= arabicNumeral;
	return found || mapping.getLowerBorder() <= arabicNumeral;
    }
}
