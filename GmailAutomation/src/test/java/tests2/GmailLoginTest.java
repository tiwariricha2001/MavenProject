package tests2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.util.Assert;

import pages.GmailHomePage;
import pages.GmailLoginPage;

public class GmailLoginTest {
	private WebDriver driver;
    private String baseUrl = "https://www.google.com/gmail/about/";
    private ExtentReports extent;
    private ExtentTest test;
    
    @BeforeClass
    public void setUp() 
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\richatiwari\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        
        // Initialize ExtentReports
        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("GmailLoginTestReport.html");
        extent.attachReporter(htmlReporter);
    }
    
    @Test
    public void loginToGmail() 
    {
    	test = extent.createTest("loginToGmail");
        GmailHomePage homePage = new GmailHomePage(driver);
        homePage.clickSignIn();
        test.log(Status.INFO, "Clicked on Sign In button");

        GmailLoginPage loginPage = new GmailLoginPage(driver);
        loginPage.enterEmail("rictae13@gmail.com");
        test.log(Status.INFO, "Entered email");

        
        loginPage.enterPassword("hpatdh@25");
        test.log(Status.INFO, "Entered password");
        
        // Add assertions or further actions after login
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped: " + result.getThrowable());
        } else {
            test.log(Status.PASS, "Test passed");
        }
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }
}
