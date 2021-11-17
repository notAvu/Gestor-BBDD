package Manager;

import java.util.Properties;

public class ConfigFileManager {
    Properties properties;

    public ConfigFileManager() {
        properties = new Properties();
    }
    public void put(String key, String value)
    {
        properties.put(key, value);
    }
}
