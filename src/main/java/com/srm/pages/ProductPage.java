package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.srm.base.BasePage;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    By searchBox = By.name("search");
    By searchBtn = By.cssSelector(".btn-default");
    By firstProduct = By.cssSelector(".product-thumb h4 a");
    By productName = By.xpath("//h1");
    By productPrice = By.xpath("//ul[@class='list-unstyled']//h2");
    By noResultMsg = By.xpath("//p[contains(text(),'There is no product')]");

    public void searchProduct(String product) {
        type(searchBox, product);
        click(searchBtn);
    }

    public void selectFirstProduct() {
        click(firstProduct);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public boolean isNoResultDisplayed() {
        return wait.waitForElement(noResultMsg).isDisplayed();
    }
}