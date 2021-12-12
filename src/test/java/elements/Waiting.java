package elements;

import browserFactory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiting extends BaseElement{

    public Waiting(By locator) {
        super(locator);
    }

    WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(),60);

    public void waitElementToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
