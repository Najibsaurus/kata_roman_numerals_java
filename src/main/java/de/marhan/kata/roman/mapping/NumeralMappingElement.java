package de.marhan.kata.roman.mapping;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * A Mapping element for arabic to roman numerals.
 * 
 * @author Markus Hanses
 * 
 */
public class NumeralMappingElement {

    private NumeralMappingElement before;

    private String roman;

    private Integer arabic;

    private Integer lowerBorder;

    /**
     * Creates a new mapping element.
     * 
     * @param before
     *            The mapping of the lower numeral.
     * @param arabic
     *            The arabic numeral.
     * @param roman
     *            The roman numeral.
     * @return The created element.
     */
    static NumeralMappingElement newInstance(NumeralMappingElement before, Integer arabic,
	    String roman) {
	NumeralMappingElement mapping = new NumeralMappingElement();
	mapping.before = before;
	mapping.roman = roman;
	mapping.arabic = arabic;
	mapping.computeLowerBorder();
	return mapping;
    }

    /**
     * Creates a new mapping element.
     * 
     * @param arabic
     *            The arabic numeral.
     * @param roman
     *            The roman numeral.
     * @return The created element.
     */
    static NumeralMappingElement newInstance(Integer arabic, String roman) {
	return NumeralMappingElement.newInstance(null, arabic, roman);
    }

    private void computeLowerBorder() {
	if (before != null) {
	    lowerBorder = arabic - before.arabic;
	}
    }

    public String getRoman() {
	return roman;
    }

    public Integer getArabic() {
	return arabic;
    }

    public NumeralMappingElement getBefore() {
	return before;
    }

    public boolean hasBefore() {
	return before != null;
    }

    public Integer getLowerBorder() {
	return lowerBorder;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}