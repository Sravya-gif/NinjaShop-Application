package com.srm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.srm.base.BasePage;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By myAccount = By.xpath("//span[text()='My Account']");
    By registerLink = By.linkText("Register");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By privacyPolicy = By.name("agree");
    By continueBtn = By.xpath("//input[@value='Continue']");

    By warningMsg = By.cssSelector(".alert-danger");

    public void navigateToRegister() {
        click(myAccount);
        click(registerLink);
    }

    public void register(String fname, String lname, String mail, String pass) {

        type(firstName, fname);
        type(lastName, lname);
        type(email, mail);
        type(telephone, "9876543210"); 
        type(password, pass);
        type(confirmPassword, pass);

        click(privacyPolicy);
        click(continueBtn);
    }

    public String getWarningMessage() {
        return getText(warningMsg);
    }
}