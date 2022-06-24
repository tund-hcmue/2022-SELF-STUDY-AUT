package com.example.core.keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

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

    /**
     * Scroll to element in page
     * @param webElement element to scroll
     * @return keyword scroll to element
     */
    public WebKeywords scrollToElement(WebElement webElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return new WebKeywords(driver);
    }

    /**
     * Clear text before set text
     * @param webElement element to set text
     * @param text value to set text for element
     * @return
     */
    public WebKeywords setText(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }
        return new WebKeywords(driver);
    }
}
