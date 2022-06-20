package com.example.core.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebKeywords {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private int timeouts = 30;

    public WebKeywords(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeouts);
    }

    /**
     * Method for open application by url provided
     * @param url
     * @throws Exception
     */
    public void openUrl(String url) throws Exception{
        if (!(url.startsWith("http://") || url.startsWith("https://"))){
            throw new Exception("Invalid url format.");
        }
        driver.get(url);
    }
    
    /**
     * Method to wait for locator of element visibility on the page
     * @param locator: like "By.xpath("xpath")" or "By.cssSelector("")"
     * @return element
     */
    public WebElement waitForLocatorOfElementVisibilities(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Method to wait for element visibility on the page
     * @param element
     * @return
     */
    public WebElement waitForElementVisibilities(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method to wait for element visibility and enable to click
     * @param element
     * @return
     */
    public WebElement waitForElementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
