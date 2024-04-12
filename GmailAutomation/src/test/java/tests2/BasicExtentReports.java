/*package tests2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.util.Assert;

public class BasicExtentReports {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void reportConfig()
	{
		htmlReporter = new ExtentSparkReporter("ExtentReportDemo.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//environment details
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user", "Prachi");
		reports.setSystemInfo("Browser", "chrome");
		
		//Visualization
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");
	}
	@Test
	public void LaunchBrowser()
	{
		//create test
		test = reports.createTest("Launch browser and open url");
		Assert.assertTrue(true);
	}
	@Test
	public void VerifyTitle()
	{
		test = reports.createTest("VerifyTitle");
		Assert.assertTrue(false);
	}
	@Test
	public void VerifyLogo()
	{
		test=reports.createTest("Verify Logo");
		Assert.assertTrue(true);
	}
	@Test
	public void VerifyEmail()
	{
		test = reports.createTest("Verify Email");
		throw new SkipException("skipping this test case with exception..");
	}
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED",ExtentColor.RED));
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED",ExtentColor.GREEN));
		}
		else if(result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED",ExtentColor.YELLOW));
		}
		
	}
	@AfterTest
	public void tearDown()
	{
		reports.flush();
	}
}*/
