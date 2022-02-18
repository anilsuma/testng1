package Pom.utils;

import java.util.Properties;

public class ConfigLoader {
private final Properties properties;
private static ConfigLoader configLoader;//as we need getinstance in other classes declared it as static so ,variable also should static

    private ConfigLoader() {
        properties=propertyUtils.propertyLoader("src/test/resources/Config.properties");

    }
    public static ConfigLoader getinstance(){
     if(configLoader==null){
      configLoader =  new ConfigLoader();
     }
     return configLoader;
    }
    public String getBaseurl(){
        String url=properties.getProperty("baseurl");
        if (url!= null) {

            return url;
        } else throw new RuntimeException("username not specified in config properties");

    }
    public String getusername() {
        String username = properties.getProperty("username");
        if (username != null) {

            return username;
        } else throw new RuntimeException("username not specified in config properties");
    }
    public String getpassword(){
        String password=properties.getProperty("password");
        if (password != null) {

            return password;
        } else throw new RuntimeException("username not specified in config properties");

    }

}
