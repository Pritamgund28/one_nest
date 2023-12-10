package com.infimatrix.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
public class ScreenshotUtil {
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            // Specify the path where you want to save the screenshot
            String destination = "screenshots/" + screenshotName + ".png";
            File finalDestination = new File(destination);
            org.apache.commons.io.FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}