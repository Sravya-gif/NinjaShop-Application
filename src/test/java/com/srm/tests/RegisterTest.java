package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {

        RegisterPage rp = new RegisterPage(driver);
        rp.navigateToRegister();
        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        rp.register("Sravya", "Test", email, "Test@123");
       boolean result = driver.getPageSource().contains("Your Account Has Been Created");

        Assert.assertTrue(result);
    }
}