package elements;

import browserFactory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseElement {
    protected final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    protected WebElement findElement() {
        return BrowserFactory.getDriver().findElement(locator);
    }

    public boolean isElementDisplayed() {
        return findElement().isDisplayed();
    }
}
