package com.srm.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.srm.utils.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");

        System.out.println(result.getName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail("Test Failed");

        String path = ScreenshotUtil.capture(DriverFactory.driver, result.getName());

        extentTest.get().addScreenCaptureFromPath(path);

        System.out.println(result.getName() + " FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush(); 
    }
}