package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

    private final WebDriver driver;
    private final Actions actions;

    private static final Logger logger =
            LogManager.getLogger(ActionsUtils.class);

    public ActionsUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void mouseHover(By locator) {

        logger.info("Performing mouse hover on element: {}", locator);

        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void moveToElementAndClick(By locator) {

        logger.info("Moving to element and clicking: {}", locator);

        WebElement element = driver.findElement(locator);
        actions.moveToElement(element)
               .click()
               .perform();
    }

    public void doubleClick(By locator) {

        logger.info("Performing double click on element: {}", locator);

        WebElement element = driver.findElement(locator);
        actions.moveToElement(element)
               .doubleClick()
               .perform();
    }

    public void dragAndDrop(By source, By target) {

        logger.info(
                "Performing drag and drop from {} to {}",
                source,
                target
        );

        WebElement sourceElement = driver.findElement(source);
        WebElement targetElement = driver.findElement(target);

        actions.dragAndDrop(
                sourceElement,
                targetElement
        ).perform();
    }

    public void rightClick(By locator) {

        logger.info("Performing right click on element: {}", locator);

        WebElement element = driver.findElement(locator);
        actions.contextClick(element).perform();
    }

    public void clickAndHold(By locator) {

        logger.info("Performing click and hold on element: {}", locator);

        WebElement element = driver.findElement(locator);
        actions.clickAndHold(element).perform();
    }
}