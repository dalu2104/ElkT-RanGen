package elkTranGen;

import java.io.IOException;
import elkTranGen.conf.Read;
import elkTranGen.out.OutputCreator;
import elkTranGen.out.OutputCreatorSpecialCase;
import elkTranGen.util.Logger;
import elkTranGen.util.PropertyNames;

/**
 * Starting point of the program.
 * 
 * @author dalu2104
 *
 */
public class Main {

	/**
	 * Main method. Does not take any parameters, all settings are made in the
	 * configuration file. Calls a read of the file and gives settings onto the
	 * output methods.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// no args allowed.
		if (args.length > 0) {
			throw new IllegalArgumentException("No arguments allowed.");
		}

		Logger.printStart();
		Logger.printLegacy();
		OutputCreator.deleteLegacy();
		OutputCreatorSpecialCase.deleteLegacy();

		// read conf
		Logger.printProperties();

		int numberOfFiles = Integer.valueOf(Read.readProperty(PropertyNames.NUMBER_OF_FILES));
		int lowerBoundAmount = Integer.valueOf(Read.readProperty(PropertyNames.LOWER_BOUND_AMOUNT));
		int upperBoundAmount = Integer.valueOf(Read.readProperty(PropertyNames.UPPER_BOUND_AMOUNT));
		int lowerBoundWidth = Integer.valueOf(Read.readProperty(PropertyNames.LOWER_BOUND_WIDHT));
		int UpperBoundWidth = Integer.valueOf(Read.readProperty(PropertyNames.UPPER_BOUND_WIDTH));
		int lowerBoundHeight = Integer.valueOf(Read.readProperty(PropertyNames.LOWER_BOUND_HEIGHT));
		int upperBoundHeight = Integer.valueOf(Read.readProperty(PropertyNames.UPPER_BOUND_HEIGHT));
		int step = Integer.valueOf(Read.readProperty(PropertyNames.STEP));

		boolean enableOneBigRegion = Boolean.valueOf(Read.readProperty(PropertyNames.SC_ENABLE_ONE_BIG_REGION));
		int lowerBoundSmallerRegionsWidth = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_LOWER_BOUND_SMALLER_REGIONS_WIDTH));
		int lowerBoundSmallerRegionsHeight = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_LOWER_BOUND_SMALLER_REGIONS_HEIGHT));
		int upperBoundSmallerRegionsWidth = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_UPPER_BOUND_SMALLER_REGIONS_WIDTH));
		int upperBoundSmallerRegionsHeight = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_UPPER_BOUND_SMALLER_REGIONS_HEIGHT));
		int lowerBoundBigRegionWidth = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_LOWER_BOUND_BIG_REGION_WIDTH));
		int lowerBoundBigRegionHeight = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_LOWER_BOUND_BIG_REGION_HEIGHT));
		int upperBoundBigRegionsWidth = Integer
				.valueOf(Read.readProperty(PropertyNames.SC_UPPER_BOUND_BIG_REGION_WIDTH));
		int upperBoundBigRegionsHeight = Integer.valueOf(Read.readProperty(PropertyNames.UPPER_BOUND_HEIGHT));

		Logger.printFileCreation();
		OutputCreator.print(numberOfFiles, lowerBoundAmount, upperBoundAmount, lowerBoundWidth, UpperBoundWidth,
				lowerBoundHeight, upperBoundHeight, step);
		if (enableOneBigRegion) {
			OutputCreatorSpecialCase.print(numberOfFiles, lowerBoundAmount, upperBoundAmount,
					lowerBoundSmallerRegionsWidth, lowerBoundSmallerRegionsHeight, upperBoundSmallerRegionsWidth,
					upperBoundSmallerRegionsHeight, lowerBoundBigRegionWidth, upperBoundBigRegionsWidth,
					lowerBoundBigRegionHeight, upperBoundBigRegionsHeight, step);
		}
		Logger.printFileCreationDone();
	}
}
