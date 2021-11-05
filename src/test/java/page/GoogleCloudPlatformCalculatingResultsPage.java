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

    @FindBy(xpath = "//*[@id=\"resultBlock\"]//h2[@class='md-title']//b[@class='ng-binding']")
    private WebElement totalEstimatedCost;

    public GoogleCloudPlatformCalculatingResultsPage(WebDriver driver)
    {
        super(driver);
    }

    public String getTotalEstimatedCost()
    {
        return totalEstimatedCost.getText().replace("Total Estimated Cost: USD ", "").replace(" per 1 month", "");
    }

    public GoogleCloudEmailEstimatePage sendEstimateByEmail()
    {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).
                until(ExpectedConditions.elementToBeClickable(emailEstimateButton)).click();
        return new GoogleCloudEmailEstimatePage(driver);
    }
}
