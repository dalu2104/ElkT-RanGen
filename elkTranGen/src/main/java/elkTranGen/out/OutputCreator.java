package elkTranGen.out;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

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
	 * @throws IOException
	 */
	public static void print(int numberOfObjects) throws IOException {

		// create output directory if it does not exist already
		if (!outputDir.exists()) {
			if (outputDir.mkdir()) {
				System.out.println("[INFO]: File output directory created.");
			}
		}

		// counter for naming the output files.
		int counter = 0;
		Random r = new Random();
		PrintWriter writer;
		String newFileName;

		//creates number of specified files
		for (int i = 0; i < numberOfObjects; i++) {
			//NEW FILE
			newFileName = "outputFiles/ElkTTestFile" + String.valueOf(counter) + ".elkt";
			System.out.println("[INFO]: Creating file >" + newFileName + "<");
			// new file with generic name
			writer = new PrintWriter(newFileName, "UTF-8");
			
			
			// header
			writer.println("algorithm: org.eclipse.elk.box");
			writer.println("");

			// body random number of Nodes
			int numberOfNodes = r.nextInt(120);

			for (int j = 0; j < numberOfNodes; j++) {
				// random size
				int width = r.nextInt(100);
				int height = r.nextInt(100);

				//body of files
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

	/** Delete, if they exist, old files from previous runs.
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
			if (outputDir.delete()) {
				System.out.println("[INFO]: Legacy deleted.");
			}
		}
	}
}
