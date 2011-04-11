package de.marhan.kata.roman;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class RomanNumberConverterGroupTest {

	RomanNumberConverter converter;

	private final Map<Integer, String> groups = new HashMap<Integer, String>();

	@Before
	public void setup() {
		converter = new RomanNumberConverter();

		groups.put(1, "I");
		groups.put(5, "V");
		groups.put(10, "X");
		groups.put(50, "L");
		groups.put(100, "C");
		groups.put(500, "D");
		groups.put(1000, "M");
	}

	@Test
	public void romanGroupOfArabicNumber_arabicGiven_romanGroupReturned()
			throws Exception {
		for (Integer arabic : groups.keySet()) {
			String roman = converter.romanGroupOfArabicNumber(arabic);
			assertThat(roman, is(groups.get(arabic)));
		}
	}
}
