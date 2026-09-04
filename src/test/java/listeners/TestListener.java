package listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import tests.BaseTest;
import utils.ExtentManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    private static final ExtentReports extentReports =
            ExtentManager.getExtentReports();

    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    private static final ConcurrentMap<String, ExtentTest> testMap =
            new ConcurrentHashMap<>();

    @Override
    public void onTestStart(ITestResult result) {

        String testName = getTestName(result);

        /*
         * Create Extent test only once.
         * During retry, reuse the same Extent test.
         */
        ExtentTest test = testMap.computeIfAbsent(
                getTestKey(result),
                key -> extentReports.createTest(testName)
        );

        extentTest.set(test);

        int attempt = getAttemptNumber(result);

        if (attempt == 1) {

            logger.info(
                    "Test started: {}",
                    testName
            );

        } else {

            logger.info(
                    "Retry attempt {} started for test: {}",
                    attempt,
                    testName
            );

            test.info(
                    "Retry attempt " + attempt + " started"
            );
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = extentTest.get();

        int attempt = getAttemptNumber(result);

        test.pass(
                "Test passed successfully"
        );

        logger.info(
                "Test passed: {} | Attempt: {}",
                result.getMethod().getMethodName(),
                attempt
        );

        removeTest(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = extentTest.get();

        Throwable throwable = result.getThrowable();

        int attempt = getAttemptNumber(result);

        /*
         * Check whether TestNG will retry this failure.
         */
        boolean willRetry =
                result.getMethod()
                        .getRetryAnalyzer(result)
                        .retry(result);

        /*
         * IMPORTANT:
         *
         * We already called retry() above, so we must NOT do this.
         *
         * This would increment the retry counter twice.
         */

        if (willRetry) {

            test.warning(
                    "Test failed on attempt "
                    + attempt
                    + ". TestNG will retry."
            );

            logger.warn(
                    "Test failed and will be retried: {} | Attempt: {}",
                    result.getMethod().getMethodName(),
                    attempt
            );

        } else {

            test.fail(throwable);

            logger.error(
                    "Test failed finally: {} | Attempt: {}",
                    result.getMethod().getMethodName(),
                    attempt,
                    throwable
            );

            captureScreenshot(
                    result,
                    test
            );
        }

        /*
         * Do NOT remove ThreadLocal here when retrying.
         */
        if (!willRetry) {
            removeTest(result);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        /*
         * TestNG can invoke onTestSkipped() during retry processing.
         *
         * Therefore we do not automatically report every skipped
         * callback as a genuine skipped test.
         */

        if (result.getMethod().getRetryAnalyzer(result) != null) {

            logger.info(
                    "Test retry callback received: {}",
                    result.getMethod().getMethodName()
            );

            return;
        }

        ExtentTest test = extentTest.get();

        test.skip("Test skipped");

        logger.warn(
                "Test skipped: {}",
                result.getMethod().getMethodName()
        );

        removeTest(result);
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

        logger.info(
                "Extent Report generated successfully"
        );
    }

    private String getTestName(ITestResult result) {

        return result.getTestClass()
                .getRealClass()
                .getSimpleName()
                + " - "
                + result.getMethod()
                .getMethodName();
    }

    private String getTestKey(ITestResult result) {

        return result.getTestClass()
                .getRealClass()
                .getName()
                + "#"
                + result.getMethod()
                .getMethodName();
    }

    private int getAttemptNumber(ITestResult result) {

        Object attribute =
                result.getAttribute("retryAttempt");

        if (attribute == null) {

            int attempt = 1;

            result.setAttribute(
                    "retryAttempt",
                    attempt
            );

            return attempt;
        }

        int attempt =
                (Integer) attribute + 1;

        result.setAttribute(
                "retryAttempt",
                attempt
        );

        return attempt;
    }

    private void captureScreenshot(
            ITestResult result,
            ExtentTest test) {

        Object testInstance =
                result.getInstance();

        if (!(testInstance instanceof BaseTest)) {
            return;
        }

        WebDriver driver =
                ((BaseTest) testInstance)
                        .getDriver();

        if (driver == null) {
            return;
        }

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyyMMdd_HHmmss"
                                )
                        );

        String screenshotName =
                result.getTestClass()
                        .getRealClass()
                        .getSimpleName()
                + "_"
                + result.getMethod()
                        .getMethodName()
                + "_"
                + timestamp;

        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        driver,
                        screenshotName
                );

        try {

            test.fail(
                    "Screenshot on final failure",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    screenshotPath
                            )
                            .build()
            );

        } catch (Exception e) {

            logger.error(
                    "Failed to attach screenshot to Extent Report",
                    e
            );
        }
    }

    private void removeTest(ITestResult result) {

        extentTest.remove();

        testMap.remove(
                getTestKey(result)
        );
    }
}