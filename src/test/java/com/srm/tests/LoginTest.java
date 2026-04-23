package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"validEmail", "validPassword", true},
                {"validEmail", "invalidPassword", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String userKey, String passKey, boolean expected) {

        LoginPage lp = new LoginPage(driver);
        lp.goToLogin();

        String user = com.srm.utils.ConfigReader.get(userKey);
        String pass = com.srm.utils.ConfigReader.get(passKey);
        lp.login(user, pass);
        boolean result = driver.getCurrentUrl().contains("account");

        
        Assert.assertEquals(result, expected);
    }
}