package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage {
	private WebDriver driver;

    @FindBy(xpath = "(//input[@id='add-to-cart-button'])")
    private WebElement addToCartButton;

    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickVisitSamsungStoreLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement samsungStoreLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("bylineInfo")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", samsungStoreLink);
        samsungStoreLink.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }
    public void selectLaptopsAndAccessories(String partialLinkText) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.partialLinkText(partialLinkText)).click();
    }
    public void popUpExit() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
         WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("attach-close_sideSheet-link")));  
         // Click on the close button
         closeButton.click();
    }
    public void selectFurniture() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchDropdownBox")));
         dropdownElement.click();
         WebElement furnitureOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Furniture']")));
         furnitureOption.click();
    }
    public void goToFresh() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement freshElement = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Fresh")));
        freshElement.click();
    }
    public void goToAmazonMiniTV() {
    	int attempts = 0;
        while (attempts < 2) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                WebElement miniTV = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Amazon miniTV")));
                miniTV.click();
                break;
            } catch (StaleElementReferenceException e) {
                // Increment attempts and retry
                attempts++;
            }
        }
    }
    public void goToMovies() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement movies = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Movies")));
    }
}
