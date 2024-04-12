package tests2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import pages.AmazonSignInPage;

public class AmazonSignInTest extends BaseClass {
	private static final Logger LOGGER = LogManager.getLogger(AmazonSignInTest.class.getName());
	
    @Test
    public void signInTest() {
        // Open Amazon homepage
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        LOGGER.info("Opened Amazon homepage and maximized the window");

        // Click on Sign In button on the navbar
        AmazonSignInPage signInPage = new AmazonSignInPage(driver);

        // Initialize AmazonSignInPage
        signInPage = PageFactory.initElements(driver, AmazonSignInPage.class);
        signInPage.clickSignIn();
        LOGGER.info("Clicked SignIn button");

        // Validate the title of the Sign In page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon Sign In";
        LOGGER.info("Actual Page Title: " + actualTitle);
        LOGGER.info("Expected Page Title: " + expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Page title is not as expected");
        
        // Enter email and click Continue
        signInPage.enterEmailAndContinue("tiwari1996.rahul7@gmail.com");
        LOGGER.info("Entered email");
        
        Assert.fail("Deliberate failure to capture screenshot");
        signInPage.enterPasswordAndContinue("richa@123");
        LOGGER.info("Entered Password");

        // Add more steps for signing in if required (e.g., entering password and clicking Sign In)
    }

}
