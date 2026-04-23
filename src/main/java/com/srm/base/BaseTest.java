package com.srm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.srm.utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}