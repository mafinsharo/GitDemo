package org.automation.testing.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// Robot imports
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ScreenshotUtil {

    // ✅ Selenium screenshot (after alert handled)
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/";
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            String filePath = path + fileName + ".png";
            Files.copy(src.toPath(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + filePath);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

    // ✅ Robot screenshot (captures alert popup)
    public static void takeFullScreenshot(WebDriver driver, String fileName) {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(screenRect);

            String path = System.getProperty("user.dir") + "/screenshots/";
            File dir = new File(path);

            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(path + fileName + ".png");
            ImageIO.write(image, "png", file);

            System.out.println("Full screenshot saved at: " + file.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }
}