package utilities;
import java.io.*;
import java.util.*;

public class ConfigReader {
    Properties prop;

    public Properties init_prop() {
        prop = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
