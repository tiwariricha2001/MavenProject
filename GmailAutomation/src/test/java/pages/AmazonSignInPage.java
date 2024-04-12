package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSignInPage {
	 private WebDriver driver;
	 
		 @FindBy  (id="nav-link-accountList-nav-line-1")
		 public WebElement login_button;
		 
	 	@FindBy(id = "nav-cart")
	    //private WebElement cartButton;
	 	private List<WebElement> cartButtons;
	 
	    @FindBy(id = "ap_email")
	    private WebElement emailInput;
	    
	    @FindBy(id = "ap_password")
	    private WebElement password;

	    @FindBy(id = "signInSubmit")
	    private WebElement signInbutton;
	    
	    @FindBy(id = "continue")
	    private WebElement continueButton;
	    
	    public void clickSignIn() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (3));
			login_button.click();	
		}
	    // Constructor
	    public AmazonSignInPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void clickCartButton() {
	    	if (cartButtons.size() >= 2) {
	            cartButtons.get(0).click();
	        } else {
	            System.out.println("Second cart button not found.");
	        }
	    }

	    // Method to enter email and click Continue
	    public void enterEmailAndContinue(String email) {
	        //emailInput.sendKeys(email);
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
	        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
	        continueButton.click();
	    }
	    public void enterPasswordAndContinue(String paswrd) {
	        password.sendKeys(paswrd);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Wait until the search button is clickable
	        wait.until(ExpectedConditions.elementToBeClickable(signInbutton));
	        signInbutton.click();
	    }
}
