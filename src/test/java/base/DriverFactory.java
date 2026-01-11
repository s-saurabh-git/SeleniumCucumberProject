package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.io.IOException;

public class DriverFactory
{
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static void initDriver() throws IOException
    {
        String browser=System.getProperty("browser"); //this comes from jenkins

        if(browser==null || browser.isEmpty())
        {
            browser= ConfigReader.getValue("browser"); // this comes from property file
        }

        switch (browser.toLowerCase())
        {
            case "chrome": driver.set(new ChromeDriver()); break;
            case "edge": driver.set(new EdgeDriver()); break;
            case "firefox": driver.set(new FirefoxDriver()); break;
            default: throw new RuntimeException("Browser not supported: "+browser);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void quitDriver()
    {
        if(getDriver() !=null)
        {
            getDriver().quit();
            driver.remove();
        }
    }
}
