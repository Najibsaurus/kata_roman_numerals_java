package de.marhan.kata.roman;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class NumberMapping {

    public static NumberMappingElement mapping_I = NumberMappingElement.newInstance(1, "I");

    public static NumberMappingElement mapping_V = NumberMappingElement.newInstance(mapping_I, 5, "V");

    public static NumberMappingElement mapping_X = NumberMappingElement.newInstance(mapping_I, 10, "X");

    public static NumberMappingElement mapping_L = NumberMappingElement.newInstance(mapping_X, 50, "L");

    public static NumberMappingElement mapping_C = NumberMappingElement.newInstance(mapping_X, 100, "C");

    public static NumberMappingElement mapping_D = NumberMappingElement.newInstance(mapping_C, 500, "D");

    public static NumberMappingElement mapping_M = NumberMappingElement.newInstance(mapping_C, 1000, "M");

    public static List<NumberMappingElement> createNumberMappingList() {
	List<NumberMappingElement> romanNumbers = new ArrayList<NumberMappingElement>();
	romanNumbers.add(mapping_I);
	romanNumbers.add(mapping_V);
	romanNumbers.add(mapping_X);
	romanNumbers.add(mapping_L);
	romanNumbers.add(mapping_C);
	romanNumbers.add(mapping_D);
	romanNumbers.add(mapping_M);
	return romanNumbers;
    }

}
