package steps;

import model.CloudPlatformModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.GoogleCloudPlatformPricingCalculatorPage;

import java.time.Duration;

public class FillTheFormSteps {
    private WebDriver driver;
    private GoogleCloudPlatformPricingCalculatorPage page;

    public FillTheFormSteps(WebDriver driver, GoogleCloudPlatformPricingCalculatorPage page) {
        this.driver = driver;
        this.page = page;
    }

    public void fillTheForm(CloudPlatformModel cloudPlatformModel) {
        driver.switchTo()
                .frame(new WebDriverWait(driver, Duration.ofSeconds(page.getWAITING_TIME()))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe"))));
        driver.switchTo()
                .frame(new WebDriverWait(driver, Duration.ofSeconds(page.getWAITING_TIME()))
                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id=\'myFrame\']"))));
        page.fillInNumberOfInstances(cloudPlatformModel.getNumberOfInstances());
        page.chooseSeries(cloudPlatformModel.getMachineSeries());
        page.chooseMachineType(cloudPlatformModel.getMachineType());
        page.addGPUs();
        page.addNumberOfGPUs(cloudPlatformModel.getNumberOfGPU());
        page.addGPUType(cloudPlatformModel.getGpuType());
        page.addLocalSSD(cloudPlatformModel.getLocalSSD());
        page.addDataCenterLocation(cloudPlatformModel.getDataCentreLocation());
        page.chooseCommittedUsage(cloudPlatformModel.getCommittedUsage());
        page.addToEstimate();
    }
}
