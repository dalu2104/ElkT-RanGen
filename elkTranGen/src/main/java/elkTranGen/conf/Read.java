package elkTranGen.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import elkTranGen.util.PropertyNames;

/**
 * @author dalu2104
 */
public class Read {

	/**
	 * Reads a given property from the properties file. Returns the value of the
	 * property or null, if property was not found.
	 *
	 * @param property
	 * @return
	 */
	public static String readProperty(PropertyNames property) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			// read config file in root directory
			String current = new java.io.File(".").getCanonicalPath();
			//input = new FileInputStream(current + System.getProperty("file.separator") + "config.properties");
			//PROBLEMS READING THE PROPERTIES FILE BECAUSE YOU EXECUTE DIRECTLY IN IDE?
			//UNCOMMENT THE LINE ABOVE AND COMMENT THE NEXT TO LINES AND YOU SHOULD BE FINE
			String rootDir = new File(current).getParentFile().getCanonicalPath();
			input = new FileInputStream(rootDir + System.getProperty("file.separator") + "config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			String returner = prop.getProperty(property.toString());

			return returner;

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
