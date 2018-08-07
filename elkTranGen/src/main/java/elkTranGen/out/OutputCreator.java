package elkTranGen.out;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import elkTranGen.util.Logger;
import elkTranGen.util.Rand;

/**
 * @author dalu2104
 */
public class OutputCreator {

	private static String current;
	private static File outputDir;

	/**
	 * Creates the given amount of files with a random number of nodes with
	 * random sizes.
	 * 
	 * @param numberOfObjects
	 *            Number of Files to be created.
	 * @param upperBoundHeight
	 *            Upper bound of the height of the nodes.
	 * @param lowerBoundHeight
	 *            Lower bound of the height of the nodes.
	 * @param upperBoundWidth
	 *            Upper bound of the width of the nodes.
	 * @param lowerBoundWidth
	 *            Lower bound of the width of the nodes.
	 * @param upperBoundAmount
	 *            Upper bound of the amount of nodes.
	 * @param lowerBoundAmount
	 *            Lower bound of the amount of nodes.
	 * @param step
	 *            Steps between single widths and heights. E.g., step of 5 will
	 *            cause dimensions of 5, 10, 15, 20,...
	 * @throws IOException
	 */
	public static void print(int numberOfObjects, int lowerBoundAmount, int upperBoundAmount, int lowerBoundWidth,
			int upperBoundWidth, int lowerBoundHeight, int upperBoundHeight, int step) throws IOException {

		// create output directory if it does not exist already
		if (!outputDir.exists()) {
			if (outputDir.mkdir()) {
				Logger.printFileOutputDirectory();
			}
		}

		// counter for naming the output files.
		int counter = 0;
		PrintWriter writer;
		String newFileName;

		// creates number of specified files
		for (int i = 0; i < numberOfObjects; i++) {
			// create file
			newFileName = "outputFiles/ElkTTestFile" + String.valueOf(counter) + ".elkt";
			Logger.printFileCreated(newFileName);
			writer = new PrintWriter(newFileName, "UTF-8");

			// header
			writer.println("algorithm: rectPacking");
			writer.println("aspectRatio: 1.3");
			writer.println("");

			// body random number of Nodes
			int numberOfNodes = Rand.randInt(lowerBoundAmount, upperBoundAmount);

			for (int j = 0; j < numberOfNodes; j++) {
				// random size
				int width = Rand.randInt(lowerBoundWidth, upperBoundWidth) * step;
				int height = Rand.randInt(lowerBoundHeight, upperBoundHeight) * step;

				// body of files
				writer.println("node n" + String.valueOf(j) + "{");
				writer.println("layout [ size:" + String.valueOf(width) + "," + String.valueOf(height) + "]");
				writer.println("label \"n" + String.valueOf(j) + "\"");
				writer.println("}");
				writer.println("");
			}

			writer.close();

			counter++;
		}
	}

	/**
	 * Delete, if they exist, old files from previous runs.
	 * 
	 * @throws IOException
	 * 
	 */
	public static void deleteLegacy() throws IOException {
		current = new java.io.File(".").getCanonicalPath();
		outputDir = new File(current + "/outputFiles");
		if (outputDir.exists()) {
			File[] allContents = outputDir.listFiles();
			if (allContents != null) {
				for (File file : allContents) {
					file.delete();
				}
			}
			Logger.printLegacyDeleted();
		}
	}
}
