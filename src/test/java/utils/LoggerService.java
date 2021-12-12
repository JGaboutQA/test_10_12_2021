package utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggerService extends AbstractWebDriverEventListener {

    public Logger logger = LoggerFactory.getLogger(LoggerService.class);

    public LoggerService() {
        super();
    }

    @BeforeMethod(alwaysRun = true)
    public void startMethod(Method m, Object[] parameters) {
        logger.info("Start method " + m.toString() + "\n with parameters: " + Arrays.asList(parameters));
    }

    @AfterMethod(alwaysRun = true)
    public void stopMethod(Method m) {
        logger.info("Stopped method " + m.toString());
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        super.beforeAlertAccept(driver);
        logger.info("alert accept");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
        logger.info("navigate to url: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        super.beforeNavigateBack(driver);
        logger.info("navigate to back page");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        super.beforeNavigateForward(driver);
        logger.info("navigate to forward page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        super.beforeNavigateRefresh(driver);
        logger.info("refresh the page");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start find element by: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element: " + by + " was found");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        logger.info("click on element: " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
        logger.info("The element: " + element + " was found");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
        logger.info("in element: " + element + "\n change value to: " + Arrays.toString(keysToSend));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.afterChangeValueOf(element, driver, keysToSend);
        logger.info("The element: " + element + " was found and value was changed");
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        super.beforeScript(script, driver);
        logger.info("used script: " + script);
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        super.afterSwitchToWindow(windowName, driver);
        logger.info("switched to window: " + windowName);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
        logger.info("switch to window: " + windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String screenshotName = "tests" + i + ".png";
        takeScreenshot((TakesScreenshot) driver, screenshotName);
        logger.info("Exception: " + throwable
                + "\nscreenShot name: " + screenshotName);
    }

    private void takeScreenshot(TakesScreenshot takeScreenshot, String screenShotName) {
        try {
            File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
            File screenshot = new File("src/test/resources/screenshots/" + screenShotName);
            Files.copy(file, screenshot);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
        logger.info("get text in element: " + element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
        logger.info("got text: " + element.getText() + "\n in element: " + element);
    }
}
