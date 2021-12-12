package pages;

import elements.TextField;
import elements.Waiting;
import org.openqa.selenium.By;

public class HomeAssignmentImagePage {

    private final String HOME_ASSIGNMENT_TEXT = "//div[contains(@class,'PanelHeader')]" +
            "//input[@data-test='item-title']";

    public void waitHomeAssignmentIsClickable() {
        Waiting waiting = new Waiting(By.xpath(HOME_ASSIGNMENT_TEXT));
    }

    public String getTextFromAttributeHomeAssignment(String attribute) {
        TextField textField = new TextField(By.xpath(HOME_ASSIGNMENT_TEXT));
        return textField.getTextAttribute(attribute);
    }
}
