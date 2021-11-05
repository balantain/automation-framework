package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners(TestListener.class)
public class CommonTest {
    protected WebDriver driver;

    protected final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod()
    public void setupBrowser()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
