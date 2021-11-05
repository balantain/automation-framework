package test;

import driver.DriverSingleton;
import model.CloudPlatformModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import service.CloudPlatformCreator;
import steps.FillTheFormSteps;

import java.util.ArrayList;

public class GoogleCloudTest
{
    private WebDriver driver;
    private final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser()
    {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void startingSearch()
    {
        GoogleCloudHomePage page = new GoogleCloudHomePage(driver);
        GoogleCloudPlatformPricingCalculatorPage pricingCalculatorPage = page.openPage().searchForTerm(SEARCH_QUERY).openCorrespondingResult();

        FillTheFormSteps fillTheFormSteps = new FillTheFormSteps(driver, pricingCalculatorPage);
        CloudPlatformModel cloudPlatformModel = CloudPlatformCreator.createCloudPlatformWithCredentialsFromProperty();
        fillTheFormSteps.fillTheForm(cloudPlatformModel);

        GoogleCloudPlatformCalculatingResultsPage googleCloudPlatformCalculatingResultsPage = new GoogleCloudPlatformCalculatingResultsPage(driver);
        String totalEstimatedCost = googleCloudPlatformCalculatingResultsPage.getTotalEstimatedCost();
        System.out.println(totalEstimatedCost);
        GoogleCloudEmailEstimatePage googleCloudEmailEstimatePage = googleCloudPlatformCalculatingResultsPage.sendEstimateByEmail();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");

        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        YopmailEmailGeneratorPage yopmailEmailGeneratorPage = new YopmailPage(driver).openPage().createEmail();
        String emailAddress = yopmailEmailGeneratorPage.getEmail();
        driver.switchTo().window(handles.get(0));
        googleCloudEmailEstimatePage.sendEmail(emailAddress);
        driver.switchTo().window(handles.get(1));
        String result = yopmailEmailGeneratorPage.checkEmail().getResultPriceFromEmail();
        Assert.assertTrue(result.contains(totalEstimatedCost));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
