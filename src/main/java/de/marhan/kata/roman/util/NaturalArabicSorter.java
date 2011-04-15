/**
 * 
 */
package de.marhan.kata.roman.util;

import java.util.Comparator;

import de.marhan.kata.roman.NumberMappingElement;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class NaturalArabicSorter implements Comparator<NumberMappingElement> {

    public int compare(NumberMappingElement mappingOne, NumberMappingElement mappingTwo) {
	return mappingOne.getArabic().compareTo(mappingTwo.getArabic());
    }
}
