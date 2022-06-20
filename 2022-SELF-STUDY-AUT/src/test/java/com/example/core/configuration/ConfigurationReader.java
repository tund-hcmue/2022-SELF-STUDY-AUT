package com.example.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {

    private Properties prop;
    private InputStream inputStream;
    private String filePath;
    
    public ConfigurationReader(String filePath) {
        this.filePath = filePath;
    }

    public String getProperty(String propertyName) throws IOException{
        String results = "";
        try {
            prop = new Properties();
            inputStream = new FileInputStream(filePath);
            
            if(inputStream != null){
                prop.load(inputStream);
            }else{
                throw new FileNotFoundException("properties file '" + filePath + "' not found in the classpath.");
            }

            results = prop.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            inputStream.close();
        }

        return results;
    }
}
