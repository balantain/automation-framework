package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPlatformCalculatingResultsPage extends AbstractPage
{
    @FindBy(xpath = "//button[contains(text(), 'Email Estimate')]")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]//h2[@class='md-title']//b[@class='ng-binding']")
    private WebElement totalEstimatedCost;

    public GoogleCloudPlatformCalculatingResultsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTotalEstimatedCost()
    {
        String totalEstimateCost = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOf(totalEstimatedCost)).getText().replace("Total Estimated Cost: USD ", "").replace(" per 1 month", "");
        logger.info("Total Estimated Cost is " + totalEstimateCost);
        return totalEstimateCost;
    }

    public GoogleCloudEmailEstimatePage sendEstimateByEmail()
    {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).
                until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        logger.info("Going to \"Send estimate by email\" block");
        return new GoogleCloudEmailEstimatePage(driver);
    }
}
