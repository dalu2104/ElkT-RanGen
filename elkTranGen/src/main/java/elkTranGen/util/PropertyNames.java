package elkTranGen.util;

/** Existing property names.
 * 
 * @author dalu2104
 *
 */
public enum PropertyNames {
	NUMBER_OF_FILES("numberOfFiles"),
	LOWER_BOUND_AMOUNT("lowerBoundAmount"),
	UPPER_BOUND_AMOUNT("upperBoundAmount"),
	LOWER_BOUND_WIDHT("lowerBoundWidth"),
	UPPER_BOUND_WIDTH("upperBoundWidth"),
	LOWER_BOUND_HEIGHT("lowerBoundHeight"),
	UPPER_BOUND_HEIGHT("upperBoundHeight"),
	STEP("step");
	
    private final String name;

    /**
     * @param text
     */
    PropertyNames(final String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }
}
