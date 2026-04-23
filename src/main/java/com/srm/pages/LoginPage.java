package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By myAccount = By.xpath("//span[text()='My Account']");
    By login = By.linkText("Login");

    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginBtn = By.xpath("//input[@value='Login']");
    By errorMsg = By.cssSelector(".alert-danger");

    public void goToLogin() {
        click(myAccount);
        click(login);
    }

    public void login(String user, String pass) {
        type(email, user);
        type(password, pass);
        click(loginBtn);
    }

    public String getError() {
        return getText(errorMsg);
    }
}