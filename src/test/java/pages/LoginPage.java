package pages;

import elements.Button;
import elements.TextField;
import org.openqa.selenium.By;
import utils.ConfigManager;

public class LoginPage extends BaseForm{

    public LoginPage() {
        super();
    }

    private final String LOGIN = ConfigManager.getProperty("login");
    private final String PASSWORD = ConfigManager.getProperty("password");
    private final String LOGIN_INPUT_XPATH = "//input[@id='user_session_email']";
    private final String PASSWORD_INPUT_XPATH = "//input[@id='user_session_password']";
    private final String BUTTON_SIGN_IN_XPATH = "//button[@type='submit']";

    public void login() {
        TextField login = new TextField(By.xpath(LOGIN_INPUT_XPATH));
        login.typeText(LOGIN);
        TextField password = new TextField(By.xpath(PASSWORD_INPUT_XPATH));
        password.typeText(PASSWORD);
        Button buttonSignIn = new Button((By.xpath(BUTTON_SIGN_IN_XPATH)));
        buttonSignIn.clickElement();
    }
}
