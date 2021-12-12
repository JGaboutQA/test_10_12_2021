package pages;

import elements.Button;
import elements.Waiting;
import org.openqa.selenium.By;

public class ConsolePage extends BaseForm {

    private final String MENU_MEDIA_LIBRARY_XPATH = "//div[contains(@class, 'ModuleNavigationLinks')]" +
            "//span[contains(text(), 'Media Library')]";

    public void waitIsMainMenuClickable() {
        Waiting waiting = new Waiting((By.xpath(MENU_MEDIA_LIBRARY_XPATH)));
        waiting.waitElementToBeClickable();
    }

    public void clickMediaLibrary() {
        Button button = new Button((By.xpath(MENU_MEDIA_LIBRARY_XPATH)));
        button.clickElement();
    }
}
