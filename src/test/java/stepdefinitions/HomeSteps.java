package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import lombok.extern.flogger.Flogger;
import managers.PageObjectManager;
import org.slf4j.Logger;
import org.testng.Assert;
import utils.Log;

public class HomeSteps
{
    private final PageObjectManager pageObjectManager;
    public static Logger logger=Log.getLogger(HomeSteps.class);

    public HomeSteps(PageObjectManager pageObjectManager)
    {
        this.pageObjectManager = pageObjectManager;
    }


    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage)
    {
        logger.info("===Comparing message with expectedMessage");
        Assert.assertEquals(pageObjectManager.getHomePage().getSuccessText(), expectedMessage, "Message not matched");

    }


}
