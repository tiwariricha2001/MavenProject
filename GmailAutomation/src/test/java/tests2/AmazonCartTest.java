package tests2;

import org.testng.annotations.Listeners;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.util.Assert;


import pages.AmazonHomePage;
import pages.AmazonProductPage;
import pages.AmazonSignInPage;
import pages.UpdateLocationPage;

@Listeners({ TestListener.class }) // Add TestListener as a listener
public class AmazonCartTest extends BaseClass 

{
		public String url;
	    private ExtentTest test;
	    private static final Logger logger = LogManager.getLogger(AmazonCartTest.class);
	    	    
	    @Test
	    public void searchAndAddToCart() throws IOException 
	    {       	    	
	    	test = extent.createTest("searchAndAddToCart");
	    	ReadConfigFile ConfigFile = new ReadConfigFile();
	    	driver.get(ConfigFile.getURL());
	        driver.manage().window().maximize();
	        logger.info("Opened Amazon website successfully");
	        
	        AmazonHomePage homePage = new AmazonHomePage(driver);
	        homePage.searchFor(ConfigFile.getProdName());
	        test.log(Status.INFO, "Searched for Samsung Galaxy");
	        logger.info("Searched for Samsung Galaxy");
	        
	        // Inside the test method
	        driver.get(ConfigFile.getProdUrl());
	        logger.info("Landed on Product Page");
	              
	        try 
	        {
	            //Assert.fail("Deliberate failure to capture screenshot");
	            AmazonProductPage productPage = new AmazonProductPage(driver);
	            productPage.addToCart();
	            logger.info("Added the product to cart");
	            test.log(Status.INFO, "Added the product to cart");
	            
	            SignInOperation();
	            logger.info("Ran SignIn test successfully");
	            
	            UpdateLocationPage locationPage = new UpdateLocationPage(driver);
	            locationPage.clickLocationButton();            
	            locationPage.enterPinCode(ConfigFile.getPincode());
	            locationPage.clickApplyButton();
	            logger.info("Updated Location");
	            
	            productPage.goToAmazonMiniTV();
	            logger.info("Landed on amazonMiniTV");
	            
	            Assert.fail("Deliberate failure to capture screenshot");
	            productPage.goToMovies();
	        } 
	        
	        catch (AssertionError e) //AssertionError
	        {
	        	String screenshotFileName = "searchAndAddToCart"; // Adjust filename as needed	            
	        	String screenshotPath = "/GmailAutomation/screenshots" + screenshotFileName + ".png"; 
	            try 
	            {
	                getScreenshot(screenshotPath);
	                test.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	                logger.error("Test failed");
	            } 
	            catch (IOException ioException) 
	            {
	                ioException.printStackTrace();
	            }
	        }
	        
	    }
	    public void SignInOperation() {
	    	ReadConfigFile ConfigFile = new ReadConfigFile();
	    	AmazonSignInPage signInPage = new AmazonSignInPage(driver);
	        signInPage.clickSignIn();
	        signInPage.enterEmailAndContinue(ConfigFile.getEmail());
	        signInPage.enterPasswordAndContinue(ConfigFile.getPassword());
	        for (int i = 0; i < 3; i++) {
	             driver.navigate().back();
	             try {
	                 Thread.sleep(3000); // Sleep for 3 seconds
	             } catch (InterruptedException e) {
	                 e.printStackTrace();
	             }
	         }
	         
	    }
	    
	    @AfterMethod
	    public void tearDown(ITestResult result) 
	    {
	        if (result.getStatus() == ITestResult.FAILURE) 
	        {
	            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
	        } 
	        else if (result.getStatus() == ITestResult.SKIP) 
	        {
	            test.log(Status.SKIP, "Test skipped: " + result.getThrowable());
	        } 
	        else 
	        {
	            test.log(Status.PASS, "Test passed");
	        }
	    }
	    
	  
	 // In the getScreenshot method
	    public static void getScreenshot(String screenshotPath) throws IOException 
	    {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(srcFile, new File(screenshotPath));
	    }
}