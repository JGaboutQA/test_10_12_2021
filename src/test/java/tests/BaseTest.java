package tests;

import browserFactory.BrowserFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ConsoleMediaLibraryPage;
import pages.ConsolePage;
import pages.HomeAssignmentImagePage;
import pages.LoginPage;
import utils.ConfigManager;
import utils.LoggerService;

import java.util.concurrent.TimeUnit;

public class BaseTest extends LoggerService {

    LoginPage loginPage = new LoginPage();
    ConsolePage consolePage = new ConsolePage();
    ConsoleMediaLibraryPage consoleMediaLibrary = new ConsoleMediaLibraryPage();
    HomeAssignmentImagePage homeAssignmentImagePage= new HomeAssignmentImagePage();

    @BeforeClass
    public void setUp() {
        BrowserFactory.getDriver().navigate().to(ConfigManager.getProperty("url"));
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        BrowserFactory.getDriver().manage().window().maximize();
    }

    @AfterClass
    public void closeBrowser() {
        BrowserFactory.getDriver().quit();
    }
}
