package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {
	private WebDriver driver;

    @FindBy(xpath = "//input[@class='nav-input nav-progressive-attribute']")
    private WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFor(String searchText) {
        searchInput.sendKeys(searchText);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait until the search button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
}
