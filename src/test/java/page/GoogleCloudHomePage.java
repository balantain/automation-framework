package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage
{
    private final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";

    @FindBy(name = "q")
    private WebElement searchBtn;

    public GoogleCloudHomePage(WebDriver driver)
    {
        super(driver);
    }

    public GoogleCloudHomePage openPage()
    {
        driver.get(GOOGLE_CLOUD_URL);
        logger.info("Google cloud main page is opened");
        return this;
    }

    public GoogleCloudSearchResultsPage searchForTerm(String searchTerm)
    {
        searchBtn.sendKeys(searchTerm);
        searchBtn.sendKeys(Keys.ENTER);
        logger.info("Searching for term " + searchTerm);
        return new GoogleCloudSearchResultsPage(driver, searchTerm);
    }
}
