package com.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.core.keywords.WebKeywords;

public class BasePage {
    public WebDriver driver;
    public WebKeywords keywords;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void waitForAlertPresent(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("finbase.vn");
            alert.accept();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    

}
