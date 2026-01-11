package pages;

import base.DriverFactory;
import org.openqa.selenium.By;

public class HomePage extends BasePage
{
    public HomePage()
    {
        this.driver= DriverFactory.getDriver();
    }

    private By successText=By.tagName("h1");

    public String getSuccessText()
    {
        return getText(successText);
    }
}
