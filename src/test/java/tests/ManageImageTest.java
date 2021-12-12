package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageImageTest extends BaseTest{

    @Test
    public void validateTextNameImage() {
        loginPage.login();
        consolePage.waitIsMainMenuClickable();
        consolePage.clickMediaLibrary();
        consoleMediaLibrary.waitIsImageHomeAssignmentClickable();
        consoleMediaLibrary.clickImgHomeAssignmentRightMouse();
        consoleMediaLibrary.clickManageMenu();
        homeAssignmentImagePage.waitHomeAssignmentIsClickable();
        Assert.assertEquals(homeAssignmentImagePage.getTextFromAttributeHomeAssignment("value"),
                "Home assignment",
                "text is not Home assignment");
    }

}
