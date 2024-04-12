package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCheckoutPage {
	
	private WebDriver driver;
	@FindBy(xpath = "//span[@id='attach-sidesheet-view-cart-button']//input[@class='a-button-input']")
    private WebElement viewCartButton;

    // Constructor
    public AmazonCheckoutPage(WebDriver driver) {
        //this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

    // Method to click on "Proceed to Checkout" button
    public void clickProceedToCheckoutButton() {
        //driver.findElement(By.id("attach-sidesheet-checkout-button")).click();
    	//driver.findElement(By.xpath("//span[contains(@class, 'a-button') and contains(@class, 'a-button-primary') and contains(@class, 'attach-primary-button') and contains(@class, 'attach-button-large') and contains(@class, 'attach-checkout-button')]"));
    	viewCartButton.click();
    	
    }

    // Method to sign in with mobile number
    public void signIn(String mobileNumber) {
    	
    	 // Click on the sign-in option on the navbar
        driver.findElement(By.id("nav-link-accountList")).click();
        
        // Locate the mobile number input field and enter the mobile number
        driver.findElement(By.id("mobileNumber")).sendKeys(mobileNumber);
        
        // Click on the continue button
        driver.findElement(By.id("continueButton")).click();
    }
}
