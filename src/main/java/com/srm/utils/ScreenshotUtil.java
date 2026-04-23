package com.srm.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + "_" + timestamp + ".png";

        try {
            org.openqa.selenium.io.FileHandler.copy(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}