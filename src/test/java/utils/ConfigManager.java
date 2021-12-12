package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties PROPERTIES = new Properties();

    public static String getProperty(String parameter) {
        if(PROPERTIES.toString().equals("{}")) {
            initProperties();
        }
        return PROPERTIES.getProperty(parameter);
    }

    private static void initProperties() {
        try (FileReader fileReader = new FileReader("src/test/resources/config.properties")){
            PROPERTIES.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
