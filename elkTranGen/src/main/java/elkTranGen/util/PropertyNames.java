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
	STEP("step"),
	
	SC_ENABLE_ONE_BIG_REGION("enableOneBigRegion"),
	SC_LOWER_BOUND_SMALLER_REGIONS_WIDTH("lowerBoundSmallerRegionsWidth"),
	SC_LOWER_BOUND_SMALLER_REGIONS_HEIGHT("lowerBoundSmallerRegionsHeight"),
	SC_UPPER_BOUND_SMALLER_REGIONS_WIDTH("upperBoundSmallerRegionsWidth"),
	SC_UPPER_BOUND_SMALLER_REGIONS_HEIGHT("upperBoundSmallerRegionsHeight"),
	SC_LOWER_BOUND_BIG_REGION_WIDTH("lowerBoundBigRegionWidth"),
	SC_LOWER_BOUND_BIG_REGION_HEIGHT("lowerBoundBigRegionHeight"),
	SC_UPPER_BOUND_BIG_REGION_WIDTH("upperBoundBigRegionsWidth"),
	SC_UPPER_BOUND_BIG_REGION_HEIGHT("upperBoundBigRegionsHeight");
	
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
