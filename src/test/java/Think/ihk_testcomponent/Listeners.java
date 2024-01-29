package Think.ihk_testcomponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Think.ihk_resources.ExtentReporterNG;


public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports extent = ExtentReporterNG.getReport();
	
	@Override
	public void onTestStart(ITestResult result) {

		    
		    // If you want to use the actual method name as the test name
		     String customTestName = result.getMethod().getMethodName();
		    
		    // If you want to use the actual method description as the test description
		     String customTestDescription = result.getMethod().getDescription();
		    
		    test = extent.createTest(customTestName, "Testcase Description: " + customTestDescription);
		    extentTest.set(test);
		
//		test = extent.createTest(result.getMethod().getDescription());
//		extentTest.set( test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {


		test.log(Status.PASS, "Test Passed");
	} 

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		extentTest.get().addScreenCaptureFromPath(result.getMethod().getMethodName(), filePath);

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		test.log(Status.SKIP, "Test Skkiped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();

	}
}
