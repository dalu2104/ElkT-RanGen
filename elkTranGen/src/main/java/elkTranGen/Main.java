package elkTranGen;

import java.io.IOException;
import elkTranGen.conf.Read;
import elkTranGen.out.OutputCreator;
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

		Logger.printFileCreation();
		OutputCreator.print(numberOfFiles, lowerBoundAmount, upperBoundAmount, lowerBoundWidth, UpperBoundWidth,
				lowerBoundHeight, upperBoundHeight, step);
		Logger.printFileCreationDone();
	}
}
