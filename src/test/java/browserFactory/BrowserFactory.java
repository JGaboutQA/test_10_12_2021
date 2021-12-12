package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.LoggerService;

public class BrowserFactory {

    private static EventFiringWebDriver driver;

    private static void createDriver() {
        String browser = System.getProperty("browser", BrowserType.CHROME);
        switch (browser){
            case "chrome":
                createChromeDriver();
                break;
            case "firefox":
                createFoxDriver();
                break;
        }
        driver.register(new LoggerService());
    }

    private static void createFoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        driver = new EventFiringWebDriver(new FirefoxDriver(firefoxOptions));
    }

    private static void createChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver(chromeOptions));
    }

    public static WebDriver getDriver(){
        if(driver == null) {
            createDriver();
        }
        return driver;
    }
}
