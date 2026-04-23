package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        CheckoutPage cp = new CheckoutPage(driver);
        cp.proceedToCheckout();
        cp.continueCheckout();
        cp.confirmOrder();
        boolean result = cp.isOrderPlaced();

        Assert.assertTrue(result);
    }

    @Test
    public void checkoutWithoutLoginTest() {

        CheckoutPage cp = new CheckoutPage(driver);
        cp.proceedToCheckout();
        boolean result = driver.getCurrentUrl().contains("login");

        Assert.assertTrue(result);
    }
}