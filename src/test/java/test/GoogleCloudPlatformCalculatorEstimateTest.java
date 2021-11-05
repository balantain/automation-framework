package test;

import model.CloudPlatformModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import service.CloudPlatformCreator;
import steps.FillTheFormSteps;

public class GoogleCloudPlatformCalculatorEstimateTest extends CommonTest
{
    @Test
    public void cloudPlatformEstimateIsEqualToManualCalculated()
    {
        GoogleCloudHomePage page = new GoogleCloudHomePage(driver);
        GoogleCloudPlatformPricingCalculatorPage pricingCalculatorPage = page.openPage().searchForTerm(SEARCH_QUERY).openCorrespondingResult();

        FillTheFormSteps fillTheFormSteps = new FillTheFormSteps(driver, pricingCalculatorPage);
        CloudPlatformModel cloudPlatformModel = CloudPlatformCreator.createCloudPlatformWithCredentialsFromProperty();
        fillTheFormSteps.fillTheForm(cloudPlatformModel);

        GoogleCloudPlatformCalculatingResultsPage googleCloudPlatformCalculatingResultsPage = new GoogleCloudPlatformCalculatingResultsPage(driver);
        String totalEstimatedCost = googleCloudPlatformCalculatingResultsPage.getTotalEstimatedCost();

        Assert.assertEquals(totalEstimatedCost, cloudPlatformModel.getManualCalculatingCost(), "Estimate price is not equal to manual calculated!");
    }
}
