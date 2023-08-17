package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	public static String getPropertyValue(String key) {
		FileReader reader = null;
		try {
			reader = new FileReader(".//configuration//Configuration.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return p.getProperty(key);
	}

}
