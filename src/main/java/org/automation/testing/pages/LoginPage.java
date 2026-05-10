package org.automation.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Locators for login page
    @FindBy(name = "proceed")
    WebElement signInBtn;

    @FindBy(linkText = "Forgot password?")
    WebElement forgotPwdLink;

    @FindBy(linkText = "Money")
    public WebElement moneyPageLink;

    @FindBy(linkText = "Privacy Policy")
    public WebElement privacyPolicyLink;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click Sign In button
    public void clickSignIn() {
        signInBtn.click();
    }

    // Navigate to Forgot Password page
    public void clickForgotPassword() {
        forgotPwdLink.click();
    }

    // Navigate to Money page
    public void clickMoney(){
        moneyPageLink.click();
    }

    public void clickPrivacyPolicy(){
        privacyPolicyLink.click();
    }
}