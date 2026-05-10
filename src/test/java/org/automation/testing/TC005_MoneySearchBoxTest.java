package org.automation.testing;

import org.automation.testing.baseclass.BaseClass;
import org.automation.testing.pages.LoginPage;
import org.automation.testing.pages.MoneyPage;
import org.automation.testing.utility.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TC005_MoneySearchBoxTest extends BaseClass {

    @Test
    public void testMoneySearchBox() {
        LoginPage loginPage = new LoginPage(driver);
        MoneyPage moneyPage = new MoneyPage(driver);

        // Step 1: Click Money link
        loginPage.clickMoney();

        // Step 2: Switch to Money window
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 3: Wait for search box and perform search via MoneyPage method
        wait.until(ExpectedConditions.visibilityOf(moneyPage.searchBox));
        moneyPage.searchBoxLocator("Tata Consultancy Services");

        // Step 4: Validate navigation by URL
        wait.until(ExpectedConditions.urlMatches("(?i).*tata.*"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.toLowerCase().contains("tata") || currentUrl.toLowerCase().contains("tcs"),
                "Search did not navigate to Tata Consultancy Services page. Current URL: " + currentUrl);

        // Step 5: Validate navigation by page title
        wait.until(ExpectedConditions.titleContains("Tata"));
        String pageTitle = driver.getTitle().toLowerCase();
        Assert.assertTrue(pageTitle.contains("tata"),
                "Page title does not match Tata Consultancy Services. Title: " + pageTitle);

        // Step 6: Screenshot
        ScreenshotUtil.takeFullScreenshot(driver, "TC005_MoneySearchBoxTest");
        System.out.println("✅ Search Box is Working fine, Test case TC005_MoneySearchBox Test passed");

        driver.navigate().back();

    }
}
