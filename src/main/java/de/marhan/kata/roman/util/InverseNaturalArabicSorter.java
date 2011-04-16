package de.marhan.kata.roman.util;

import java.util.Comparator;

import de.marhan.kata.roman.mapping.NumeralMappingElement;

/**
 * Sorts the mapping elements by arabic numeral in inverse natural order.
 * 
 * @author Markus Hanses
 * 
 */
public class InverseNaturalArabicSorter implements Comparator<NumeralMappingElement> {

    public int compare(NumeralMappingElement mappingOne, NumeralMappingElement mappingTwo) {
	return inverse(mappingOne.getArabic().compareTo(mappingTwo.getArabic()));
    }

    private int inverse(int compareTo) {
	return compareTo == 0 ? compareTo : compareTo < 0 ? 1 : -1;
    }

}
