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
	 * Creates the given amount of files with a random number of nodes with random
	 * sizes.
	 * 
	 * @param numberOfObjects
	 * @param upperBoundHeight
	 * @param lowerBoundHeight
	 * @param upperBoundWidth
	 * @param lowerBoundWidth
	 * @param upperBoundAmount
	 * @param lowerBoundAmount
	 * @throws IOException
	 */
	public static void print(int numberOfObjects, int lowerBoundAmount, int upperBoundAmount, int lowerBoundWidth,
			int upperBoundWidth, int lowerBoundHeight, int upperBoundHeight) throws IOException {

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
			writer.println("algorithm: org.eclipse.elk.box");
			writer.println("");

			// body random number of Nodes
			int numberOfNodes = Rand.randInt(lowerBoundAmount, upperBoundAmount);

			for (int j = 0; j < numberOfNodes; j++) {
				// random size
				int width = Rand.randInt(lowerBoundWidth, upperBoundWidth);
				int height = Rand.randInt(lowerBoundHeight, upperBoundHeight);

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
