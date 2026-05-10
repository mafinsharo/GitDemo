package org.automation.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;

    // Locators for forgot password page
    @FindBy(css = "button.signin-btn")
    WebElement nextBtn;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click Next button without entering email
    public void clickNext() {
        nextBtn.click();
    }
}