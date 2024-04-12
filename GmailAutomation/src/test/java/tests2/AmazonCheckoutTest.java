package tests2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.AmazonCheckoutPage;
import pages.AmazonProductPage;

public class AmazonCheckoutTest extends BaseClass 
{
	
	private ExtentTest test;
    private static final Logger logger = LogManager.getLogger(AmazonCheckoutTest.class);
    
    /*@Override
    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        super.setUp(browser); // Call the setUp method of the BaseClass
        // You can add additional setup logic specific to AmazonCheckoutTest here
    }*/

    @Test(dependsOnMethods = "tests2.AmazonCartTest.searchAndAddToCart")
    public void proceedToCheckout()
    {
	    test = extent.createTest("proceedToCheckout");
	    logger.info("Proceeding to checkout");
	    
	    // Example interaction with elements on the product page
        //driver.findElement(By.id("proceedToCheckoutButton")).click();
        //logger.info("Clicked on proceed to checkout button");

        AmazonCheckoutPage checkoutPage = new AmazonCheckoutPage(driver);
        //checkoutPage.clickProceedToCheckoutButton();
        //logger.info("Clicked on proceed to checkout button");
        driver.findElement(By.tagName("body")).click();
        logger.info("Clicked anywhere on the page to close proceed to checkout screen");
        
        checkoutPage.signIn("7728810830");
        logger.info("Entered mobile number and clicked on continue");
    }
}