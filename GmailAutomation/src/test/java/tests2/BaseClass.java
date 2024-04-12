package tests2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners({ TestListener.class }) // Add TestListener as a listener
public class BaseClass {
	protected static WebDriver driver;
    protected ExtentReports extent;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome")String browser) {
        // Initialize WebDriver based on browser configuration
        if (browser.equalsIgnoreCase("chrome")) 
        {
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\richatiwari\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "chromedriver-win64/chromedriver-win64/chromedriver.exe");
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("ie")) 
        {
            //System.setProperty("webdriver.ie.driver", "C:\\Users\\richatiwari\\Downloads\\IEDriverServer_x64_4.14.0\\IEDriverServer.exe");
        	System.setProperty("webdriver.ie.driver","IEDriverServer_x64_4.14.0\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) 
        {
            //System.setProperty("webdriver.ie.driver", "C:\\Users\\richatiwari\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
        	System.setProperty("webdriver.ie.driver", "geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
            driver = new FirefoxDriver();
        } 
        else 
        {
            throw new IllegalArgumentException("Invalid browser specified");
        }

        extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("TestReport.html");
        extent.attachReporter(htmlReporter);
        TestListener.setDriver(driver);
    }

    @AfterClass
    public void tearDown() 
    {
        driver.quit();
        extent.flush();
    }
}
