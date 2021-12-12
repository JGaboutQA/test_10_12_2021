package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextField extends BaseElement{

    public TextField(By locator) {
        super(locator);
    }

    public void typeText(String text) {
        WebElement element = findElement();
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getTextAttribute(String attribute) {
        return findElement().getAttribute(attribute);
    }
}
