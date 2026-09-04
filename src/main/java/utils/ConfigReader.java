package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants.FrameworkConstants;

public final class ConfigReader {

    private static final Logger logger =
            LogManager.getLogger(ConfigReader.class);

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream inputStream =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream(
                                     FrameworkConstants.CONFIG_FILE)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "config.properties not found");
            }

            properties.load(inputStream);

            logger.info("Configuration file loaded successfully");

        } catch (IOException e) {

            logger.error(
                    "Failed to load configuration file",
                    e);

            throw new RuntimeException(
                    "Failed to load configuration file",
                    e);
        }
    }

    private ConfigReader() {
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        logger.debug(
                "Reading configuration property: {}",
                key);

        return value;
    }
}