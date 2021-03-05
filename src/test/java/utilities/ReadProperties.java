package utilities;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties{

    private static ReadProperties instance = null;

    private Properties props = null;

    private ReadProperties(){
        props = new Properties();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            System.out.println("No such file present.");
        }
    }

    public static synchronized ReadProperties getInstance(){
        if (instance == null)
            instance = new ReadProperties();
        return instance;
    }

    public String getValue(String propKey){
        return this.props.getProperty(propKey);
    }
}