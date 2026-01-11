package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import utils.ConfigReader;
import utils.Log;
import utils.ScreenshotUtil;

import java.io.IOException;

public class Hooks
{
    public static Logger logger= Log.getLogger(Hooks.class);
    @Before
    public void setUp() throws IOException {
        logger.info("====Initializing WebDriver====");
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getValue("baseUrl"));
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.takeScreenshot(scenario.getName());
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        logger.info("===Quiting WebDriver====");
        DriverFactory.quitDriver();
    }
}
