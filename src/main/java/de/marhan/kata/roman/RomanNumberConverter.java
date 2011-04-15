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

    public String convert(int number) {

	StringBuilder builder = new StringBuilder();

	return builder.toString();
    }

    String findRomanForArabic(Integer arabicNumber) {
	return findMappingForArabic(arabicNumber).getRoman();
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
