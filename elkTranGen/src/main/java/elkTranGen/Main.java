package elkTranGen;

import java.io.IOException;
import elkTranGen.conf.Read;
import elkTranGen.out.OutputCreator;

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
	 */
	public static void main(String[] args) {
		// no args allowed.
		if(args.length > 0) {
			throw new IllegalArgumentException("No arguments allowed.");
		}
		//info
		System.out.println("[INFO]: Starting random ElkT Generator.");
		
		//delete legacy pollution
		System.out.println("[INFO]: Deleting legacy files.");
		try {
		OutputCreator.deleteLegacy();
		} catch (NumberFormatException e) {
			System.out.println("[INFO]: Number format exception.");
		} catch (IOException e) {
			System.out.println("[INFO]: IOException.");
		}
		
		//read conf
		System.out.println("[INFO]: Reading properties. ");
		String numberOfFiles = Read.readProperty("numberOfFiles");
		
		// call output
		System.out.println("[INFO]: Starting file creation.");
		try {
			OutputCreator.print(Integer.valueOf(numberOfFiles));
		} catch (NumberFormatException e) {
			System.out.println("[INFO]: Number format exception.");
		} catch (IOException e) {
			System.out.println("[INFO]: IOException.");
		}
		
		System.out.println("[INFO]: File generation done.");
	}
}
