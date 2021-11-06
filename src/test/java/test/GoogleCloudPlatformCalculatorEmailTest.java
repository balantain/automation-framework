package test;

import model.CloudPlatformModel;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import service.CloudPlatformCreator;
import steps.FillTheFormSteps;

import java.util.ArrayList;

public class GoogleCloudPlatformCalculatorEmailTest extends CommonTest {
    @Test
    public void cloudPlatformEstimateCanBeSentByEmail() {
        GoogleCloudHomePage page = new GoogleCloudHomePage(driver);
        GoogleCloudPlatformPricingCalculatorPage pricingCalculatorPage = page.openPage().searchForTerm(SEARCH_QUERY).openCorrespondingResult();

        FillTheFormSteps fillTheFormSteps = new FillTheFormSteps(driver, pricingCalculatorPage);
        CloudPlatformModel cloudPlatformModel = CloudPlatformCreator.createCloudPlatformWithCredentialsFromProperty();
        fillTheFormSteps.fillTheForm(cloudPlatformModel);

        GoogleCloudPlatformCalculatingResultsPage googleCloudPlatformCalculatingResultsPage = new GoogleCloudPlatformCalculatingResultsPage(driver);
        String totalEstimatedCost = googleCloudPlatformCalculatingResultsPage.getTotalEstimatedCost();

        System.out.println(totalEstimatedCost);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");

        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        YopmailEmailGeneratorPage yopmailEmailGeneratorPage = new YopmailPage(driver).openPage().createEmail();
        String emailAddress = yopmailEmailGeneratorPage.getEmail();

        driver.switchTo().window(handles.get(0));
        GoogleCloudEmailEstimatePage googleCloudEmailEstimatePage = googleCloudPlatformCalculatingResultsPage.sendEstimateByEmail();
        googleCloudEmailEstimatePage.sendEmail(emailAddress);

        driver.switchTo().window(handles.get(1));

        YopmailMailBoxPage yopmailMailBoxPage = yopmailEmailGeneratorPage.checkEmail();

        String result = yopmailMailBoxPage.getResultPriceFromEmail();
        Assert.assertTrue(result.contains(totalEstimatedCost));
    }
}
