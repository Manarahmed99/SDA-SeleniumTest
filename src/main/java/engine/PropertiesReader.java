package engine;


import io.qameta.allure.Step;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    /**
     * Breakout assignment: 30 minutes
     * <br/> - create a properties reader, read the target browser and base url from it
     * <br/> - reading test data from json files
     * <br/> - generating single html allure report
     * <br/> - implementing fluent POM design with abstract page class
     * <br/> - optional: create the incorrect username test case
     */
    public static Properties props;
    @Step ("Loading configuration properties")
    public static void readPropertyFile(String configPath) {
        props = new Properties();
        try {
            // Load properties from the classpath
            props.load(new FileInputStream(configPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
