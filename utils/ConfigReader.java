package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

	    Properties prop;

	    public Properties ConfigReader() {
	        try {
	            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	            prop = new Properties();
	            prop.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
	    }

	    
	}

