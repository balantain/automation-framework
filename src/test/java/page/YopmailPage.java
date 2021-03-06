package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    WebElement emailGenerator;

    private final static String YOPMAIL_URL = "https://yopmail.com/";

    public YopmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public YopmailPage openPage() {
        driver.get(YOPMAIL_URL);
        logger.info("Yopmail page is opened");
        return this;
    }

    public YopmailEmailGeneratorPage createEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).
                until(ExpectedConditions.elementToBeClickable(emailGenerator)).click();
        logger.info("Generating email");
        return new YopmailEmailGeneratorPage(driver);
    }
}
