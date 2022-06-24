package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.example.core.keywords.WebKeywords;

public class GuruLoginPage extends BasePage{

    public WebKeywords keywords;

    public GuruLoginPage(WebDriver driver) {
        super(driver);
    }

    //Action
    public void actionLogin(){
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//input[@id = 'email']"))));
        WebElement txtEmail = driver.findElement(By.xpath("//input[@id = 'email']"));
        WebElement txtPassword = driver.findElement(By.xpath("//input[@id = 'password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type = 'submit']"));
        txtEmail.sendKeys("thoa.nguyen+op@finbase.vn");
        txtPassword.sendKeys("finbase.vn");
        btnLogin.click();
    }
    
    public boolean isLoginSuccess() throws Exception{
        WebElement sectionPage;
        try {
            sectionPage = driver.findElement(By.xpath("//section[@class='ant-layout ant-layout-has-sider MainLayout_layout__3wKfs']"));
        } catch (Exception e) {
            throw new Exception("Exception: " + e.getMessage());
        }
        
        if (sectionPage != null){
            return true;
        } else {
            return false;
        }
    }

    //Declare element
    
    
}
