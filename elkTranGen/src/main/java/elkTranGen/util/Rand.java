package elkTranGen.util;

import java.util.Random;

/** Provides utility methods for random.
 * 
 * @author dalu2104
 *
 */
public class Rand {
	private static Random rand = new Random();
	
	//taken from https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
