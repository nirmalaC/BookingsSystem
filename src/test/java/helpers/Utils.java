package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class Utils {

    public static String fs = File.separator;

    /**
     *This is the method to read the config.properties file
     */
    public static Properties readPropertiesFile() throws IOException {
        String path = "src" + fs + "test" + fs + "resources" + fs + "config.properties";
        String configPath = Paths.get(path).toAbsolutePath().toString();

        FileInputStream fis;
        fis = new FileInputStream(configPath);
        Properties property = new Properties();
        property.load(fis);
        return property;
    }

    public static char randomChar(){
        Random rnd = new Random();
        return (char) ('a' + rnd.nextInt(26));
    }
}
