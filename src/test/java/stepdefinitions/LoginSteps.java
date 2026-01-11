package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.testng.Assert;

public class LoginSteps
{
    private final PageObjectManager pageObjectManager;

    public LoginSteps(PageObjectManager pageObjectManager)
    {
        this.pageObjectManager=pageObjectManager;
    }

    @Given("user is on login page")
    public void user_is_on_login_page()
    {

    }
    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password)
    {
        pageObjectManager.getLoginPage().enterUsername(username);
        pageObjectManager.getLoginPage().enterPassword(password);
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button()
    {
        pageObjectManager.getLoginPage().clickSubmitButton();
    }


}
