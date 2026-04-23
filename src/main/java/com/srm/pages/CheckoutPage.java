package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.srm.base.BasePage;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By checkoutBtn = By.linkText("Checkout");

    By continueBtn = By.id("button-payment-address");
    By confirmOrderBtn = By.id("button-confirm");

    By successMsg = By.xpath("//h1[contains(text(),'Your order has been placed')]");

    public void proceedToCheckout() {
        click(checkoutBtn);
    }

    public void continueCheckout() {
        click(continueBtn);
    }

    public void confirmOrder() {
        click(confirmOrderBtn);
    }

    public boolean isOrderPlaced() {
        return wait.waitForElement(successMsg).isDisplayed();
    }
}