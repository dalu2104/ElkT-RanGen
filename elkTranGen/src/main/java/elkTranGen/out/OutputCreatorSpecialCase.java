package elkTranGen.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import elkTranGen.util.Logger;
import elkTranGen.util.Rand;

/**
 * @author dalu2104
 */
public class OutputCreatorSpecialCase {

	private static String current;
	private static File outputDir;

	/**
	 * Delete, if they exist, old files from previous runs.
	 * 
	 * @throws IOException
	 * 
	 */
	public static void deleteLegacy() throws IOException {
		current = new java.io.File(".").getCanonicalPath();
		outputDir = new File(current + "/outputFilesSpecialCase");
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

	/**
	 * 
	 * @param numberOfFiles
	 * @param lowerBoundAmount
	 * @param upperBoundAmount
	 * @param lowerBoundSmallerRegionsWidth
	 * @param lowerBoundSmallerRegionsHeight
	 * @param upperBoundSmallerRegionsWidth
	 * @param upperBoundSmallerRegionsHeight
	 * @param lowerBoundBigRegionWidth
	 * @param upperBoundBigRegionsWidth
	 * @param lowerBoundBigRegionHeight
	 * @param upperBoundBigRegionsHeight
	 * @param step
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void print(int numberOfFiles, int lowerBoundAmount, int upperBoundAmount,
			int lowerBoundSmallerRegionsWidth, int lowerBoundSmallerRegionsHeight, int upperBoundSmallerRegionsWidth,
			int upperBoundSmallerRegionsHeight, int lowerBoundBigRegionWidth, int upperBoundBigRegionsWidth,
			int lowerBoundBigRegionHeight, int upperBoundBigRegionsHeight, int step) throws FileNotFoundException, UnsupportedEncodingException {

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
		for (int i = 0; i < numberOfFiles; i++) {
			// create file
			newFileName = "outputFilesSpecialCase/SpecialCaseTestFile" + String.valueOf(counter) + ".elkt";
			Logger.printFileCreated(newFileName);
			writer = new PrintWriter(newFileName, "UTF-8");

			// header
			writer.println("algorithm: rectPacking");
			writer.println("aspectRatio: 1.3");
			writer.println("");

			// body random number of Nodes
			int numberOfNodes = Rand.randInt(lowerBoundAmount, upperBoundAmount);
			
			//split numberOfNodes randomly to simulate random amount of nodes before/after big region
			int splitBeforeAfter = Rand.randInt(0, numberOfNodes);
			//find smaller rectangles width and height as well as big ones
			int smallerRectwidth = Rand.randInt(lowerBoundSmallerRegionsWidth, upperBoundSmallerRegionsWidth) * step;
			int smallerRectHeight = Rand.randInt(lowerBoundSmallerRegionsHeight, upperBoundSmallerRegionsHeight) * step;
			int bigRectWidth = Rand.randInt(lowerBoundBigRegionWidth, upperBoundBigRegionsWidth) * step;
			int bigRectHeight = Rand.randInt(lowerBoundBigRegionHeight, upperBoundBigRegionsHeight) * step;

			for (int j = 0; j < numberOfNodes; j++) {
				writer.println("node n" + String.valueOf(j) + "{");

				//print the one big file at the split
				if(j == splitBeforeAfter) {
					writer.println("layout [ size:" + String.valueOf(bigRectWidth) + "," + String.valueOf(bigRectHeight) + "]");										
				} else {
					writer.println("layout [ size:" + String.valueOf(smallerRectwidth) + "," + String.valueOf(smallerRectHeight) + "]");					
				}
				
				writer.println("label \"n" + String.valueOf(j) + "\"");
				writer.println("}");
				writer.println("");
			}

			writer.close();

			counter++;
		}

	}
}
