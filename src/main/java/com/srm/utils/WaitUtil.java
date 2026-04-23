package com.srm.utils;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitUtil {

    WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        return wait.until(d -> d.findElement(locator));
    }
}