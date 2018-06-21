package elkTranGen.util;

/** Class that makes log calls to the command line.
 * 
 * @author dalu2104
 *
 */
public class Logger {
	
	/**
	 *  Informs, that program just started.
	 */
	public static void printStart() {
		System.out.println("[INFO]: Starting random ElkT Generator.");
	}
	
	/**
	 *  Informs about call to delete legacy method.
	 */
	public static void printLegacy() {
		System.out.println("[INFO]: Deleting legacy files.");
	}
	
	/**
	 *  Informs that properties are about to be read.
	 */
	public static void printProperties() {
		System.out.println("[INFO]: Reading properties. ");
	}
	
	/**
	 *  Informs that file are about to be created..
	 */
	public static void printFileCreation() {
		System.out.println("[INFO]: Starting file creation.");
	}
	
	/**
	 *  Informs that files have been created.
	 */
	public static void printFileCreationDone() {
		System.out.println("[INFO]: File generation done.");
	}
	
	/**
	 *  Informs that file output directory has been created..
	 */
	public static void printFileOutputDirectory() {
		System.out.println("[INFO]: File output directory created.");
	}
	
	/**
	 *  Informs that file with @parameter new File Name has been created.
	 */
	public static void printFileCreated(String newFileName) {
		System.out.println("[INFO]: Creating file >" + newFileName + "<");
	}
	
	/**
	 *  Informs that flegacy has been deleted.
	 */
	public static void printLegacyDeleted() {
		System.out.println("[INFO]: Legacy deleted.");
	}
}
