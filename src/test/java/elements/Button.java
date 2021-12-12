package elements;

import browserFactory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Button extends BaseElement{

    public Button(By locator) {
        super(locator);
    }

    public void clickElement() {
        findElement().click();
    }

    public void clickRightMouse() {
        Actions actions = new Actions(BrowserFactory.getDriver());
        WebElement element = findElement();
        actions.contextClick(element).perform();
    }
}
