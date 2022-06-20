package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keywords.WebKeywords;

public class GuruLoginPage extends BasePage{

    public WebKeywords keywords;

    public GuruLoginPage(WebDriver driver) {
        super(driver);
    }

    //Action
    
    /**
     * Method for login on page
     */
    public void actionLogin(){
        txtEmail.sendKeys(email);
        keywords.waitForElementToBeClickable(btnSubmit);
        btnSubmit.click();
    }

    /**
     * Method for verify that the url of page has contains the email of user when user login.
     * @return true or false
     */
    public boolean isUrlCurrentPageContainsEmailOfUser(){
        String urlCurrent = driver.getCurrentUrl();
        if (urlCurrent.contains(email)){
            return true;
        } else {
            return false;
        }
    }

    //Declare element
    // private WebElement txtEmail = driver.findElement(By.xpath("//input[@name = 'emailid']"));
    private WebElement txtEmail = keywords.waitForLocatorOfElementVisibilities(By.xpath("//input[@name = 'emailid']"));
    private WebElement btnSubmit = driver.findElement(By.xpath("//input[@name = 'btnLogin']"));
    
    private String email = "tund.fit@gmail.com";
    
}
