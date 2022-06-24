package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.utils.listener.ReportListener;
import com.example.pages.GuruLoginPage;

@Listeners(ReportListener.class)
public class GuruLoginTest extends BaseTest{
    @Test(testName = "Verify that login function work correctly")
    public void verfyThatLoginFunctionWorkCorrectly() throws Exception{
        GuruLoginPage guruLoginPage = new GuruLoginPage(driver);
        guruLoginPage.waitForAlertPresent();
        guruLoginPage.actionLogin();
        Assert.assertTrue(guruLoginPage.isLoginSuccess());
    }
}
