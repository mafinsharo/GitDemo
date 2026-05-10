package org.automation.testing;

import org.automation.testing.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.automation.testing.baseclass.BaseClass;
import org.automation.testing.utility.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC003_PrivacyPolicyTest extends BaseClass {
    @Test
    public void testPrivacyPolicyPage() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for Privacy Policy link to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.privacyPolicyLink));
        loginPage.clickPrivacyPolicy();

        // Switch to the new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Wait until title contains "Rediff"
        wait.until(ExpectedConditions.titleContains("Rediff"));
        String pageTitle = driver.getTitle();
        System.out.println("Page Title : " + pageTitle);

        Assert.assertTrue(pageTitle.contains("Rediff: Welcome to rediff.com"), "Privacy Policy page not displayed!");

        ScreenshotUtil.takeFullScreenshot(driver, "TC003_PrivacyPolicy");
        System.out.println("✅ Test case TC003_PrivacyPolicy passed - Test case is valid");
        driver.navigate().back();

    }
}
