package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WaitUtils {

    private final WebDriverWait wait;

    private static final Logger logger =
            LoggerFactory.getLogger(WaitUtils.class);

    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void elementToBeClickable(By locator) {

        logger.debug(
                "Waiting for element to be clickable: {}",
                locator
        );

        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void visibilityOfElementLocated(By locator) {

        logger.debug(
                "Waiting for element visibility: {}",
                locator
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void presenceOfElementLocated(By locator) {

        logger.debug(
                "Waiting for element presence: {}",
                locator
        );

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for Ajax loader to appear
    public void waitForLoaderToAppear(By locator) {

        logger.debug(
                "Waiting for loader to appear: {}",
                locator
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for Ajax loader to disappear
    public void waitForLoaderToDisappear(By locator) {

        logger.debug(
                "Waiting for loader to disappear: {}",
                locator
        );

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}