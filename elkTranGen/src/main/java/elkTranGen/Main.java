package elkTranGen;

import java.io.IOException;
import elkTranGen.conf.Read;
import elkTranGen.out.OutputCreator;
import elkTranGen.util.Logger;

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
		int numberOfFiles = Integer.valueOf(Read.readProperty("numberOfFiles"));
		int lowerBoundAmount = Integer.valueOf(Read.readProperty("lowerBoundAmount"));
		int upperBoundAmount = Integer.valueOf(Read.readProperty("upperBoundAmount"));
		int lowerBoundWidth = Integer.valueOf(Read.readProperty("lowerBoundWidth"));
		int UpperBoundWidth = Integer.valueOf(Read.readProperty("upperBoundWidth"));
		int lowerBoundHeight = Integer.valueOf(Read.readProperty("lowerBoundHeight"));
		int upperBoundHeight = Integer.valueOf(Read.readProperty("upperBoundHeight"));

		Logger.printFileCreation();
		OutputCreator.print(numberOfFiles, lowerBoundAmount, upperBoundAmount, lowerBoundWidth, UpperBoundWidth,
				lowerBoundHeight, upperBoundHeight);
		Logger.printFileCreationDone();
	}
}
