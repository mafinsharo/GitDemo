package org.automation.testing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.automation.testing.baseclass.BaseClass;
import org.automation.testing.pages.LoginPage;
import org.automation.testing.pages.ForgotPasswordPage;
import org.automation.testing.utility.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC002_ForgotPasswordAlertTest extends BaseClass {
    @Test
    public void testForgotPasswordAlert() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPassword();

        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);
        forgotPage.clickNext();

        Thread.sleep(1000);
        ScreenshotUtil.takeFullScreenshot(driver, "TC002_ForgotPasswordAlert");

        // Explicit wait for alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());

        String alertText2 = alert2.getText();
        System.out.println("Actual Alert Text : " + alertText2);
        System.out.println("Expected Alert Text : " + "Please enter your email ID");

        Assert.assertEquals(alertText2, "Please enter your email ID", "Unexpected alert message!");
        alert2.accept();
        System.out.println("Alert text matched successfully !");


        System.out.println("✅ Test case TC002_ForgotPasswordAlert passed - Test case is valid");

        driver.navigate().back();
        System.out.println("changes made in tc002");

    }
}
