/**
 * 
 */
package de.marhan.kata.roman.util;

import java.util.Comparator;

import de.marhan.kata.roman.NumeralMappingElement;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class NaturalArabicSorter implements Comparator<NumeralMappingElement> {

    public int compare(NumeralMappingElement mappingOne, NumeralMappingElement mappingTwo) {
	return mappingOne.getArabic().compareTo(mappingTwo.getArabic());
    }
}
