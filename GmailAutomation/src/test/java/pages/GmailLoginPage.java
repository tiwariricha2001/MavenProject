package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage {
	
	private WebDriver driver;

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement nextButton;

    @FindBy(name = "Passwd")
    //@FindBy(className = "rFrNMe i79UJc YKooDc zKHdkd sdJrJc")
    private WebElement passwordInput;

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
        nextButton.click();
        //WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10)); // Wait for up to 10 seconds
        //wait.until(ExpectedConditions.visibilityOf(passwordInput));
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
        nextButton.click();
    }
}
