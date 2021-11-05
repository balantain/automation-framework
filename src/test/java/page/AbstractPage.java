package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage
{
    protected WebDriver driver;
    protected final int WAITING_TIME = 10;
    protected final Logger logger = LogManager.getRootLogger();

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getWAITING_TIME() {
        return WAITING_TIME;
    }
}
