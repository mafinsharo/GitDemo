package org.automation.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage {
    WebDriver driver;

    @FindBy(linkText = "Feedback")
    public WebElement feedBackLink;

    @FindBy(id = "srchword") // correct locator for search box
    public WebElement searchBox;

    public MoneyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // initialize @FindBy elements
    }

    public void clickFeedbackLink() {
        feedBackLink.click();
    }

    // Perform search operation with Enter key
    public void searchBoxLocator(String query) {
        searchBox.sendKeys(query + org.openqa.selenium.Keys.ENTER);
    }
}
