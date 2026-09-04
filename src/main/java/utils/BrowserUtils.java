package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    private final WebDriver driver;
    private final JavascriptExecutor js;

    private static final Logger logger =
            LogManager.getLogger(BrowserUtils.class);

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Windows Switching

    public void switchToChildWindow() {

        logger.info("Switching to child window");

        String parent = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {

            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                logger.info("Switched to child window");
                break;
            }
        }
    }

    public void switchToParentWindow(String parentWindowHandle) {

        logger.info("Switching to parent window");

        driver.switchTo().window(parentWindowHandle);
    }

    public void switchToIndexWindow(int index) {

        logger.info("Switching to window at index: {}", index);

        List<String> windows =
                new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(index));
    }

    // Alerts Handling

    public void acceptAlert() {

        logger.info("Accepting alert");

        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {

        logger.info("Dismissing alert");

        driver.switchTo().alert().dismiss();
    }

    public void sendKeysToAlert(String message) {

        logger.info("Entering text into alert");

        driver.switchTo().alert().sendKeys(message);
    }

    public String getAlertText() {

        logger.info("Getting alert text");

        return driver.switchTo().alert().getText();
    }

    // JavascriptExecutor

    public void jsClick(By locator) {

        logger.info("Performing JavaScript click: {}", locator);

        WebElement element = driver.findElement(locator);

        js.executeScript(
                "arguments[0].click();",
                element
        );
    }

    public void jsSendKeys(By locator, String value) {

        logger.info("Entering text using JavaScript: {}", locator);

        WebElement element = driver.findElement(locator);

        js.executeScript(
                "arguments[0].value=arguments[1];",
                element,
                value
        );
    }

    public void enableElement(By locator) {

        logger.info("Enabling element using JavaScript: {}", locator);

        WebElement element = driver.findElement(locator);

        js.executeScript(
                "arguments[0].removeAttribute('disabled');",
                element
        );
    }

    // Navigation Methods

    public void navigateBack() {

        logger.info("Navigating back");

        driver.navigate().back();
    }

    public void navigateForward() {

        logger.info("Navigating forward");

        driver.navigate().forward();
    }

    public void refreshPage() {

        logger.info("Refreshing page");

        driver.navigate().refresh();
    }

    public void navigateTo(String url) {

        logger.info("Navigating to URL");

        driver.navigate().to(url);
    }
}