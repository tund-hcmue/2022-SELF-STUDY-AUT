package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.GuruLoginPage;

public class GuruLoginTest extends BaseTest{
    @Test(testName = "Verify that login function work correctly")
    public void verfyThatLoginFunctionWorkCorrectly(){
        GuruLoginPage guruLoginPage = new GuruLoginPage(driver);
        guruLoginPage.actionLogin();
        Assert.assertTrue(guruLoginPage.isUrlCurrentPageContainsEmailOfUser());
    }
}
