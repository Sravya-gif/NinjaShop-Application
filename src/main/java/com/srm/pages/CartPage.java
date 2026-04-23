package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By addToCartBtn = By.id("button-cart");
    By successMsg = By.cssSelector(".alert-success");

    By cartBtn = By.id("cart");
    By viewCartBtn = By.xpath("//strong[text()='View Cart']");
    By productName = By.xpath("//td[@class='text-left']/a");
    By quantityBox = By.xpath("//input[contains(@name,'quantity')]");
    By updateBtn = By.xpath("//button[@data-original-title='Update']");
    By removeBtn = By.xpath("//button[@data-original-title='Remove']");
    By emptyCartMsg = By.xpath("//p[contains(text(),'Your shopping cart is empty')]");

    public void addToCart() {
        click(addToCartBtn);
        wait.waitForElement(successMsg);
    }
    
    public int getCartCount() {

        String text = getText(By.id("cart-total"));
        String number = text.split(" ")[0];

        return Integer.parseInt(number);
    }
    
    By updateSuccessMsg = By.xpath("//div[contains(@class,'alert-success')]");

    public boolean isUpdateSuccessDisplayed() {
        return wait.waitForElement(updateSuccessMsg).isDisplayed();
    }
   
    public void openCart() {

        click(cartBtn);

        wait.waitForElement(viewCartBtn);

        click(viewCartBtn);
    }

    public String getProductName() {
        return getText(productName);
    }

    public int getQuantity() {
        String qty = wait.waitForElement(quantityBox).getAttribute("value");
        return Integer.parseInt(qty);
    }

    public void updateQuantity(String qty) {

        type(quantityBox, qty);
        click(updateBtn);

        wait.waitForElement(updateSuccessMsg);
    }

    public void removeProduct() {
        click(removeBtn);
        wait.waitForElement(emptyCartMsg);
    }

    public boolean isCartEmpty() {
        return wait.waitForElement(emptyCartMsg).isDisplayed();
    }
}