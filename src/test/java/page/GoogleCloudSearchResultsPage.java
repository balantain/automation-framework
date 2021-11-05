package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudSearchResultsPage extends AbstractPage
{
    private String searchTerm;

    @FindBy(xpath = "//div[contains(@class, 'gsc-result')]//*[contains(text(), 'Google Cloud Platform Pricing Calculator')]")
    private WebElement resultCalculator;

    public GoogleCloudSearchResultsPage(WebDriver driver, String searchTerm)
    {
        super(driver);
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPlatformPricingCalculatorPage openCorrespondingResult()
    {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.elementToBeClickable(resultCalculator)).click();
        logger.info("Corresponding result is opened");
        return new GoogleCloudPlatformPricingCalculatorPage(driver);
    }
}
