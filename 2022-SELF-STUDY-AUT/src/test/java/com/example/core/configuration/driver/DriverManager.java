package com.example.core.configuration.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static WebDriver getDriver(String browser) throws Exception{
        switch (browser){
            case "CHROME":
                return new Chrome().createDriver();
            default:
                throw new Exception("Driver is not found");
        }
    }
}
