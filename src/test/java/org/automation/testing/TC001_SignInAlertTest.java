package org.automation.testing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.automation.testing.baseclass.BaseClass;
import org.automation.testing.pages.LoginPage;
import org.automation.testing.utility.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC001_SignInAlertTest extends BaseClass {
    @Test
    public void testSignInAlert() {
        LoginPage loginPage = new LoginPage(driver);

        // Click Sign In
        loginPage.clickSignIn();

        // Explicit wait for alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());

        String alertText1 = alert1.getText();
        System.out.println("Alert Text : " + alertText1);
        System.out.println("Expected Alert Text : " + "Please enter a valid user name");

        ScreenshotUtil.takeFullScreenshot(driver, "TC001_SignInAlert");

        Assert.assertEquals(alertText1, "Please enter a valid user name", "Unexpected alert message!");
        alert1.accept();

        System.out.println("Alert text matched successfully !");

        // Optional: wait for page state after alert is closed
        wait.until(ExpectedConditions.titleContains("Login")); // adjust condition if needed

        System.out.println("✅ Test case TC001_SignInAlert passed - Test case is valid");
        System.out.println("Made changes in this code");


    }
}
