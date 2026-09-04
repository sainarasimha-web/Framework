package factory;

import java.net.MalformedURLException;
import java.net.URI;
sai narasimha
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverFactory {

    private static final Logger logger =
            LogManager.getLogger(DriverFactory.class);

    private static final String GRID_URL =
            "http://localhost:4444";

    private DriverFactory() {

    }

    public static WebDriver createDriver(String browser) {

        logger.info(
                "Creating WebDriver for browser: {}",
                browser
        );

        switch (browser.toLowerCase()) {

        case "chrome":

            logger.info(
                    "Launching Chrome browser through Selenium Grid"
            );

            try {

                ChromeOptions options = new ChromeOptions();

                return new RemoteWebDriver(
                        URI.create(GRID_URL).toURL(),
                        options
                );

            } catch (MalformedURLException e) {

                logger.error(
                        "Invalid Grid URL: {}",
                        GRID_URL,
                        e
                );

                throw new RuntimeException(
                        "Unable to connect to Selenium Grid",
                        e
                );
            }

        case "edge":

            logger.info(
                    "Launching Edge browser through Selenium Grid"
            );

            try {

                EdgeOptions options = new EdgeOptions();

                return new RemoteWebDriver(
                        URI.create(GRID_URL).toURL(),
                        options
                );

            } catch (MalformedURLException e) {

                logger.error(
                        "Invalid Grid URL: {}",
                        GRID_URL,
                        e
                );

                throw new RuntimeException(
                        "Unable to connect to Selenium Grid",
                        e
                );
            }

        case "firefox":

            logger.info("Launching Firefox browser");

            return new FirefoxDriver();

        default:

            logger.error(
                    "Unsupported browser: {}",
                    browser
            );

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }
    }
}
