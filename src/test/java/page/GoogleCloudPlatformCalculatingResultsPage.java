package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPlatformCalculatingResultsPage extends AbstractPage
{
    @FindBy(xpath = "//button[contains(text(), 'Email Estimate')]")
    private WebElement emailEstimateButton;

    public GoogleCloudPlatformCalculatingResultsPage(WebDriver driver)
    {
        super(driver);
    }

    public GoogleCloudEmailEstimatePage sendEstimateByEmail()
    {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).
                until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return new GoogleCloudEmailEstimatePage(driver);
    }
}
