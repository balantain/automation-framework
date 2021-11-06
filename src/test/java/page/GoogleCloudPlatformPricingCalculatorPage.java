package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.XpathUtils;

import java.time.Duration;

public class GoogleCloudPlatformPricingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(), \"Number of instances\")]/.././/input[@name='quantity']")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(), \"Series\")]/..//md-select-value[@class='md-select-value']")
    private WebElement seriesField;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(), \"Machine type\")]/..//md-select-value[@class='md-select-value']")
    private WebElement machineTypeField;

    @FindBy(xpath = "//div[@class='ng-scope layout-row']//md-checkbox[@aria-label='Add GPUs']/div[@class='md-container md-ink-ripple']")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUMenu;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeMenu;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDMenu;

    @FindBy(xpath = "//md-select[contains(@placeholder, 'Datacenter location')]")
    private WebElement datacenterLocationMenu;

    @FindBy(xpath = "//md-select[contains(@placeholder, 'Committed usage')]")
    private WebElement committedUsageMenu;

    @FindBy(xpath = "//div[@class='compute-engine-block']//form[@name='ComputeEngineForm']//button[contains(text(), 'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public GoogleCloudPlatformPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillInNumberOfInstances(String numberOfInstances) {
        numberOfInstancesField.sendKeys(String.valueOf(numberOfInstances));
        logger.info("Input number of instances: " + numberOfInstances);
    }

    public void chooseSeries(String series) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(seriesField)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).
                until(ExpectedConditions.visibilityOf(driver.findElement((By.
                        xpath(XpathUtils.createSpecialXpath("//div[contains(text(), '')]/..", series)))))).click();
        logger.info("Input machine series " + series);
    }

    public void chooseMachineType(String machineType) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(machineTypeField)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.
                        xpath(XpathUtils.createSpecialXpath("//div[contains(text(), '')]/..", machineType))))).click();
        logger.info("Input machine type: " + machineType);
    }

    public void addGPUs() {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(addGPUCheckbox)).click();
    }

    public void addNumberOfGPUs(String numberOfGpu) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(numberOfGPUMenu)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions
                        .visibilityOf(driver.findElement(By.xpath(XpathUtils
                                .createSpecialXpath("//md-option[contains(@ng-repeat, 'GpuNumbers')]/div[contains(text(), '')]/..", numberOfGpu))))).click();
        logger.info("Input number of GPU: " + numberOfGpu);
    }

    public void addGPUType(String gpuType) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(gpuTypeMenu)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).
                until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(XpathUtils.createSpecialXpath("//div[contains(text(), '')]/..", gpuType))))).click();
        logger.info("Input GPU type: " + gpuType);
    }

    public void addLocalSSD(String localSSD) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(localSSDMenu)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.xpath(XpathUtils.createSpecialXpath("//div[contains(text(), '')]", localSSD))))).click();
        logger.info("Input local SSD: " + localSSD);
    }

    public void addDataCenterLocation(String dataCentreLocation) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(datacenterLocationMenu)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOf(driver
                        .findElement(By.xpath(XpathUtils
                                .createSpecialXpath("//md-select-menu[@class='md-overflow']//div[contains(text(), '')]/..", dataCentreLocation))))).click();
        logger.info("Input data center location: " + dataCentreLocation);
    }

    public void chooseCommittedUsage(String committedUsage) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(committedUsageMenu)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath(XpathUtils
                                .createSpecialXpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(), '')]/..", committedUsage))))
                .click();
        logger.info("Input committed usage: " + committedUsage);
    }

    public void addToEstimate() {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.elementToBeClickable(addToEstimateButton)).click();
        logger.info("Adding to estimate");
    }
}
