package de.marhan.kata.roman;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author Markus Hanses
 * 
 */
public class NumberMappingElement {

    private NumberMappingElement before;

    private String roman;

    private Integer arabic;

    private Integer lowerBorder;

    static NumberMappingElement newInstance(NumberMappingElement before, Integer number, String roman) {
	NumberMappingElement mapping = new NumberMappingElement();
	mapping.before = before;
	mapping.roman = roman;
	mapping.arabic = number;
	mapping.computeLowerBorder();
	return mapping;
    }

    static NumberMappingElement newInstance(Integer number, String roman) {
	NumberMappingElement mapping = new NumberMappingElement();
	mapping.roman = roman;
	mapping.arabic = number;
	return mapping;
    }

    private void computeLowerBorder() {
	if (before != null) {
	    Integer arabicOfSubstractionGroup = before.arabic;
	    lowerBorder = arabic - arabicOfSubstractionGroup;
	}
    }

    public String getRoman() {
	return roman;
    }

    public Integer getArabic() {
	return arabic;
    }

    public NumberMappingElement getBefore() {
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

    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this);
    }

}