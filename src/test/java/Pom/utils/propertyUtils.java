package Pom.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertyUtils {


    public static Properties propertyLoader(String Filepath){

        Properties properties=new Properties();
        BufferedReader reader;
        try {
            reader=new BufferedReader(new FileReader(Filepath));
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }
}
