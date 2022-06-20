package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.example.core.configuration.ConfigurationReader;
import com.example.core.configuration.driver.DriverManager;
import com.example.core.keywords.WebKeywords;
import com.example.pages.BasePage;

public class BaseTest {
    public WebDriver driver;
    public WebKeywords keywords;
    public ConfigurationReader config;
    public BasePage basePage;

    @BeforeMethod
    public void setUp() throws Exception{
        try {
            config = new ConfigurationReader("src/test/java/com/example/core/configuration/Config.properties");
            driver = DriverManager.getDriver(config.getProperty("browser"));

            keywords = new WebKeywords(driver);
            keywords.openUrl(config.getProperty("url"));

            int implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
