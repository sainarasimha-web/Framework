package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {

        logger.info("Test setup started");
 
        driver = DriverFactory.createDriver(browser);

        logger.info("Browser launched");

        driver.get(ConfigReader.getProperty("url"));

        logger.info("Application URL opened");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            logger.info("Closing browser");

            driver.quit();

            logger.info("Browser closed");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}