package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.RegisterPage;

public class ValidationTest extends BaseTest {

    @Test
    public void emptyFieldValidationTest() {

        RegisterPage rp = new RegisterPage(driver);
        rp.navigateToRegister();
        rp.register("", "", "", "");
        boolean result = driver.getPageSource().contains("Warning");

        Assert.assertTrue(result);
    }

    @Test
    public void invalidEmailTest() {

        RegisterPage rp = new RegisterPage(driver);
        rp.navigateToRegister();
        rp.register("Test", "User", "invalidemail", "Test@123");
        boolean result = driver.getPageSource().contains("E-Mail Address does not appear");

        Assert.assertTrue(result);
    }
}