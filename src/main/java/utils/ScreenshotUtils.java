package utils;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {

    private static final Logger logger =
            LogManager.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
    }

    public static String captureScreenshot(
            WebDriver driver, String screenshotName) {

        try {
            logger.info(
                    "Capturing screenshot: {}",
                    screenshotName
            );

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String path = "test-output/screenshots/"
                    + screenshotName + ".png";

            File destination = new File(path);

            destination.getParentFile().mkdirs();

            org.openqa.selenium.io.FileHandler
                    .copy(source, destination);

            String absolutePath =
                    destination.getAbsolutePath();

            logger.info(
                    "Screenshot saved successfully: {}",
                    absolutePath
            );

            return absolutePath;

        } catch (IOException e) {

            logger.error(
                    "Failed to capture screenshot: {}",
                    screenshotName,
                    e
            );

            throw new RuntimeException(
                    "Failed to capture screenshot: "
                            + screenshotName,
                    e
            );
        }
    }
}