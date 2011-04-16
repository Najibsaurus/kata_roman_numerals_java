package de.marhan.kata.roman;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * @author Markus Hanses
 * 
 */
@Ignore("activate to see what happens")
public class RomanNumeralPrintTest {

    @Test
    public void printArabicAndRoman() throws Exception {
	RomanNumeralConverter converter = new RomanNumeralConverter();
	for (int arabic = 1; arabic <= 5000; arabic++) {
	    String roman = converter.convert(arabic);
	    System.out.println(String.format("%s = %s", arabic, roman));
	}
    }

}
