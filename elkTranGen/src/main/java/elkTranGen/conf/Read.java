package elkTranGen.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;

/**
 *  @author dalu2104
 */
public class Read {

	/** Reads a given property from the properties file. Returns the value of the property or null, if property was not found.
	 *
	 * @param property
	 * @return
	 */
	public static String readProperty(String property) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			//read config file in root directory
			String current = new java.io.File( "." ).getCanonicalPath();
			File file = new File(current);
			String rootDir = file.getParentFile().getCanonicalPath();

			input = new FileInputStream(rootDir + System.getProperty("file.separator") +  "config.properties");
			
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			String returner = prop.getProperty(property);

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
