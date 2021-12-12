package pages;

import elements.Button;
import elements.Waiting;
import org.openqa.selenium.By;

public class ConsoleMediaLibraryPage extends BaseForm {

    private final String IMAGE_HOME_ASSIGNMENT = "//img[@alt='Home assignment']";
    private final String MANAGE_IMAGE = "//div[@data-test='action-manage-btn']";

    public void waitIsImageHomeAssignmentClickable() {
        Waiting waiting = new Waiting((By.xpath(IMAGE_HOME_ASSIGNMENT)));
        waiting.waitElementToBeClickable();
    }

    public void clickImgHomeAssignmentRightMouse() {
        Button button = new Button(By.xpath(IMAGE_HOME_ASSIGNMENT));
        button.clickRightMouse();
    }

    public void clickManageMenu () {
        Button button = new Button(By.xpath(MANAGE_IMAGE));
        button.clickElement();
    }
}
