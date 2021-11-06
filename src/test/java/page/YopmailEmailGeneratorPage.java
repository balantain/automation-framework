package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailEmailGeneratorPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='egen']")
    private WebElement email;

    @FindBy(xpath = "//span[contains(text(), \'Проверить почту\')]/..")
    private WebElement checkEmailButton;

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getEmail() {
        String emailAddress = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOf(email)).getText();
        logger.info("Email address " + emailAddress + " is copied to clipboard");
        return emailAddress;

    }

    public YopmailMailBoxPage checkEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).until(ExpectedConditions.visibilityOf(checkEmailButton)).click();
        logger.info("Going to mail box");
        return new YopmailMailBoxPage(driver);
    }
}
