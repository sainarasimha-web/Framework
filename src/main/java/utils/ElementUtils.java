package utils;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

    private final WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(ElementUtils.class);

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }
 
    // WebElement Methods

    public void click(By locator) {
        logger.info("Clicking element: {}", locator);
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String value) {
        logger.info("Entering text into element: {}", locator);
        driver.findElement(locator).sendKeys(value);
    }

    public void clear(By locator) {
        logger.info("Clearing element: {}", locator);
        driver.findElement(locator).clear();
    }

    public String getText(By locator) {
        logger.info("Getting text from element: {}", locator);
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        logger.debug("Checking if element is displayed: {}", locator);
        return driver.findElement(locator).isDisplayed();
    }

    public boolean isEnabled(By locator) {
        logger.debug("Checking if element is enabled: {}", locator);
        return driver.findElement(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        logger.debug("Checking if element is selected: {}", locator);
        return driver.findElement(locator).isSelected();
    }

    // Select Dropdown

    public void selectByVisibleText(By locator, String visibleText) {
        logger.info(
                "Selecting '{}' from dropdown: {}",
                visibleText,
                locator
        );

        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }

    public void selectByIndex(By locator, int index) {
        logger.info(
                "Selecting index '{}' from dropdown: {}",
                index,
                locator
        );

        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void selectByValue(By locator, String value) {
        logger.info(
                "Selecting value '{}' from dropdown: {}",
                value,
                locator
        );

        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public List<WebElement> getAllDropdownValues(By locator) {
        logger.info("Getting all dropdown values: {}", locator);

        Select select = new Select(driver.findElement(locator));
        return select.getOptions();
    }

    // Checkboxes

    public void selectCheckbox(By locator) {
        WebElement element = driver.findElement(locator);

        if (!element.isSelected()) {
            logger.info("Selecting checkbox: {}", locator);
            element.click();
        }
    }

    public void deselectCheckBox(By locator) {
        WebElement element = driver.findElement(locator);

        if (element.isSelected()) {
            logger.info("Deselecting checkbox: {}", locator);
            element.click();
        }
    }

    // Radio Buttons

    public void selectRadioButton(By locator) {
        WebElement element = driver.findElement(locator);

        if (!element.isSelected()) {
            logger.info("Selecting radio button: {}", locator);
            element.click();
        }
    }
}