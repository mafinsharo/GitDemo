package org.automation.testing;

import org.automation.testing.baseclass.BaseClass;
import org.automation.testing.pages.LoginPage;
import org.automation.testing.pages.MoneyPage;
import org.automation.testing.utility.ScreenshotUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC004_MoneyFeedbackTest extends BaseClass {

    @Test
    public void validateFeedbackLinkInMoneyPage() {
        // Step 1: Initialize page objects
        MoneyPage moneyPage = new MoneyPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 2: Click Money link (from LoginPage)
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.moneyPageLink));
        loginPage.clickMoney();

        // Step 3: Handle window switching (if Money opens in new tab/window)
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Step 4: Click Feedback link on MoneyPage
        wait.until(ExpectedConditions.elementToBeClickable(moneyPage.feedBackLink));
        moneyPage.clickFeedbackLink();


        // Step 5: Validate navigation (example: check URL or page title)
        wait.until(ExpectedConditions.urlContains("feedback"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("feedback"),
                "Feedback link did not navigate correctly. Current URL: " + currentUrl);

        System.out.println("Feedback Page Opened successfully and Validated");

        ScreenshotUtil.takeFullScreenshot(driver, "TC004_FeedbackTest");
        System.out.println("✅ Test case TC004_FeedbackTest passed - Test case is valid");

        driver.navigate().back();

    }
}
