package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	
	private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInButton;

    public GmailHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signInButton.click();
    }
}
