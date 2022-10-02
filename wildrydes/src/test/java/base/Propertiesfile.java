package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertiesfile {
	public static Properties loadPropertyFile(String filename) {
		FileInputStream file;
		Properties prop = null;
		try {
			file = new FileInputStream(filename);
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
