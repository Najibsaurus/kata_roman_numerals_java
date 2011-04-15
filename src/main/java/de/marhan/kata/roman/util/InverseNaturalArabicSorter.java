package de.marhan.kata.roman.util;

import java.util.Comparator;

import de.marhan.kata.roman.NumberMappingElement;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class InverseNaturalArabicSorter implements Comparator<NumberMappingElement> {

    public int compare(NumberMappingElement mappingOne, NumberMappingElement mappingTwo) {
	return inverse(mappingOne.getArabic().compareTo(mappingTwo.getArabic()));
    }

    private int inverse(int compareTo) {
	return compareTo == 0 ? compareTo : compareTo < 0 ? 1 : -1;
    }

}
