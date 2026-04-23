package com.srm.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath = "reports/ExtentReport.html";

            spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("E-Commerce Automation Report");
            spark.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "Sravya");

        }

        return extent;
    }
}