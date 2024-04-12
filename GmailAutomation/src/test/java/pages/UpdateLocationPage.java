package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateLocationPage {
	private WebDriver driver;
	
	@FindBy(id="nav-global-location-popover-link")
	 public WebElement location_button;
	
	@FindBy(id="GLUXZipInputSection")
	 public WebElement pin_locator;
	
	@FindBy(id="GLUXZipUpdate")
	 public WebElement apply_button;
	
	 public UpdateLocationPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	public void clickLocationButton() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		location_button.click();
		
	}
	
	public void enterPinCode(String pincode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pinCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")));
		pinCodeInput.sendKeys(pincode);
    }
	
	public void clickApplyButton() {
		apply_button.click();
	}
	public void scrollToTop() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0);");
	}
	
	//GLUXZipUpdate
}
