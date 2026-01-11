package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
    public LoginPage()
    {
        this.driver= DriverFactory.getDriver();
    }

    private By usernameField=By.id("username");
    private By passwordField=By.id("password");
    private By submitButton= By.id("submit");


    public void enterUsername(String username)
    {
        type(usernameField, username);
    }

    public void enterPassword(String password)
    {
        type(passwordField, password);
    }

    public void clickSubmitButton()
    {
        click(submitButton);
    }


}
