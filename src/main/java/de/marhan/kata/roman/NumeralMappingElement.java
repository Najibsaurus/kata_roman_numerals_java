package de.marhan.kata.roman;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class NumeralMappingElement {

    private NumeralMappingElement before;

    private NumeralMappingElement after;

    private String roman;

    private Integer arabic;

    private Integer lowerBorder;

    static NumeralMappingElement newInstance(NumeralMappingElement before, Integer number,
	    String roman) {
	NumeralMappingElement mapping = new NumeralMappingElement();
	mapping.before = before;
	mapping.roman = roman;
	mapping.arabic = number;
	mapping.computeLowerBorder();
	return mapping;
    }

    static NumeralMappingElement newInstance(NumeralMappingElement before, Integer number,
	    String roman, NumeralMappingElement after) {
	NumeralMappingElement mapping = new NumeralMappingElement();
	mapping.before = before;
	mapping.roman = roman;
	mapping.arabic = number;
	mapping.after = after;
	mapping.computeLowerBorder();
	return mapping;
    }

    static NumeralMappingElement newInstance(Integer number, String roman) {
	NumeralMappingElement mapping = new NumeralMappingElement();
	mapping.roman = roman;
	mapping.arabic = number;
	return mapping;
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

    public NumeralMappingElement getAfter() {
	return after;
    }

    public Integer getLowerBorder() {
	return lowerBorder;
    }

    @Override
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }

}