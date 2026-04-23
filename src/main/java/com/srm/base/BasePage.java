package com.srm.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.srm.utils.WaitUtil;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtil(driver);
    }

    public void click(By locator) {
        wait.waitForElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = wait.waitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getText(By locator) {
        return wait.waitForElement(locator).getText();
    }
}